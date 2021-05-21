package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.api.ModulesApi;
import de.noventi.cm.runtime.model.SetupModulesParamDTO;
import de.noventi.cm.runtime.model.StatusModuleReturnDTO;
import de.noventi.cm.runtime.model.StatusModulesReturnDTO;
import de.noventi.cm.runtime.module.domain.Action;
import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.CommonModules;
import de.noventi.cm.runtime.module.domain.SetupModulesParamReader;
import de.noventi.cm.runtime.module.domain.Type;
import io.swagger.annotations.ApiParam;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ModulesController implements ModulesApi {

  private SetupModulesParamReader setupModulesParamReader = new SetupModulesParamReader();

  @Autowired
  private JarInstaller jarInstaller;

  @Autowired
  private DockerInstaller dockerInstaller;

  @Autowired
  private PostgresInstaller postgresInstaller;

  public ModulesController () {
    log.info("Create " + getClass().getName());
  }

  @Override
  public ResponseEntity<Void> installModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    try {
      log.info("called setupModules <" + setupModulesParamDTO + ">");
      CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());
      File path = new File(setupModulesParamDTO.getPath());

      for (CommonModule next : commonModules.getCommonModule()) {
        if (next.getAction().equals(Action.INSTALL)) {
          log.info("Install module " + next);
          if (next.getType().equals(Type.JAR)) {
            jarInstaller.install(path, next);
          } else if (next.getType().equals(Type.DOCKER)) {
            dockerInstaller.install(path, next);
          }

          if (next.isSql()) {
            postgresInstaller.install(path, next);
          }
        }
        else if (next.getAction().equals(Action.UNINSTALL)) {
          log.info("Uninstall module " + next);
          File modulePath = new File (path, next.getId());
          FileUtils.deleteDirectory(modulePath);

          if (next.isSql()) {
            postgresInstaller.install(path, next);
          }
        }
      }
      log.info("installModules finished");
    }catch (Exception e) {
      log.error("Error installing modules: " + e.getLocalizedMessage(), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return new ResponseEntity<Void>( HttpStatus.OK );
  }

  private boolean isModuleAffected (SetupModulesParamDTO setupModulesParamDTO, CommonModule commonModule) {
    boolean isAffected = false;
    if (setupModulesParamDTO.getAffectedModules() == null ||setupModulesParamDTO.getAffectedModules().isEmpty()) {
      log.info("Common Module " + commonModule.getId() + " is affected because affected modules is empty, defaulting to all modules");
      isAffected = true;
    }
    else {
      isAffected = setupModulesParamDTO.getAffectedModules().contains(commonModule.getId());
      log.info("Common Module " + commonModule.getId() + " is affected: " + isAffected + "(affected modules: " + setupModulesParamDTO.getAffectedModules() + ")");
    }

    return isAffected;

  }

  @Override
  public ResponseEntity<Void> startModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    try {
      log.info("called startModules <" + setupModulesParamDTO + ">");
      CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());
      File path = new File(setupModulesParamDTO.getPath());

      ExecutorService executorService = Executors.newCachedThreadPool();
      for (CommonModule next : commonModules.getCommonModule()) {
        if (isModuleAffected(setupModulesParamDTO, next) &&
            next.getAction().equals(Action.INSTALL)) {
          executorService.execute(new Runnable() {
            @Override public void run() {
              log.info("Start module " + next);
              if (next.getType().equals(Type.JAR)) {
                jarInstaller.start(path, next);
              } else if (next.getType().equals(Type.DOCKER)) {
                dockerInstaller.start(path, next);
              }
            }
          });
        }
      }
      log.info("startModules finished");
    } catch (Exception e) {
      log.error("Error starting modules: " + e.getLocalizedMessage(), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return new ResponseEntity<Void>( HttpStatus.OK );
  }

  public ResponseEntity<Void> stopModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    log.info("called stopModules <" + setupModulesParamDTO + ">");
    File path = new File(setupModulesParamDTO.getPath());
    CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());

    ExecutorService executorService = Executors.newCachedThreadPool();
    for (CommonModule next : commonModules.getCommonModule()) {
      if (isModuleAffected(setupModulesParamDTO, next)) {
        executorService.execute(new Runnable() {
          @Override public void run() {
            log.info("Stop module " + next);
            if (next.getType().equals(Type.JAR)) {
              jarInstaller.stop(path, next);
            } else if (next.getType().equals(Type.DOCKER)) {
              dockerInstaller.stop(path, next);
            }
          }
        });
      }

    }
    log.info("stopModules finished");

    return new ResponseEntity<Void>( HttpStatus.OK );
  }

  private Installer getTypicalInstaller (final CommonModule module) {
    if (module.getType().equals(Type.JAR))
      return jarInstaller;
    else if (module.getType().equals(Type.DOCKER))
        return dockerInstaller;
    else
      throw new IllegalStateException("No implementation for installer " + module.getType() + " found");
  }

  public ResponseEntity<StatusModulesReturnDTO> statusModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    File path = new File(setupModulesParamDTO.getPath());
    CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());

    StatusModulesReturnDTO statusModulesReturnDTO = new StatusModulesReturnDTO();


    for (CommonModule next: commonModules.getCommonModule()) {
      Installer installer = getTypicalInstaller(next);
      ModuleStatus state = installer.getState(path, next);
      StatusModuleReturnDTO statusModuleReturnDTO = new StatusModuleReturnDTO();
      statusModuleReturnDTO.setId(next.getId());
      statusModuleReturnDTO.setRunning(state.isRunning());
      statusModuleReturnDTO.setInstanceId(state.getInstanceId());
      statusModulesReturnDTO.addModulesItem(statusModuleReturnDTO);
    }

    return ResponseEntity.ok(statusModulesReturnDTO);

  }
}
