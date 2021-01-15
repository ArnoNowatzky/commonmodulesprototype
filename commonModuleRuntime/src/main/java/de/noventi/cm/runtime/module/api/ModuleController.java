package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.api.ModuleApi;
import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.CommonModules;
import de.noventi.cm.runtime.module.domain.SetupModulesParamReader;
import de.noventi.cm.runtime.module.domain.Type;
import de.noventi.cm.runtime.model.SetupModulesParamDTO;
import io.swagger.annotations.ApiParam;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ModuleController implements ModuleApi {

  private SetupModulesParamReader setupModulesParamReader = new SetupModulesParamReader();

  @Autowired
  private JarInstaller jarInstaller;

  @Autowired
  private DockerInstaller dockerInstaller;

  @Override
  public ResponseEntity<Void> installModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    try {
      log.info("called setupModules <" + setupModulesParamDTO + ">");
      CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());
      File path = new File(setupModulesParamDTO.getPath());

      for (CommonModule next : commonModules.getCommonModule()) {
        log.info("Install module " + next);
        if (next.getType().equals(Type.JAR)) {
          jarInstaller.install(path, next);
        } else if (next.getType().equals(Type.DOCKER)) {
          dockerInstaller.install(path, next);
        }
      }
      log.info("installModules finished");
    }catch (Exception e) {
      log.error("Error installing modules: " + e.getLocalizedMessage(), e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    return new ResponseEntity<Void>( HttpStatus.OK );
  }

  @Override
  public ResponseEntity<Void> startModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    try {
      log.info("called startModules <" + setupModulesParamDTO + ">");
      CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());
      File path = new File(setupModulesParamDTO.getPath());

      ExecutorService executorService = Executors.newCachedThreadPool();
      for (CommonModule next : commonModules.getCommonModule()) {
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
    if (path.listFiles() != null) {
      for (File next : path.listFiles()) {
        if (next.isDirectory()) {
          File applicationPidFile = new File(next, "application.pid");
          if (applicationPidFile.exists()) {
            try {
              String pid = FileUtils.readFileToString(applicationPidFile, Charset.defaultCharset());
              log.info("Shutdown service " + next.getName() + " with pid " + pid);

              if (SystemUtils.IS_OS_WINDOWS) {
                throw new IllegalStateException("NYI");
              }
              else {
                try {
                  Runtime.getRuntime().exec("kill " + pid).waitFor();
                } catch (InterruptedException e) {
                  log.error("Error killing process with pid " + pid);
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
              }

            } catch (IOException e) {
              log.error("Error reading application pid file " + applicationPidFile.getAbsolutePath());
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
          }
          else
            log.warn("Service " + next.getName() + " does not contain a pidfile " + applicationPidFile.getAbsolutePath());
        }

      }
    }
    log.info("stopModules finished");

    return new ResponseEntity<Void>( HttpStatus.OK );
    //application.pid
  }
}

/**
 *   schemas:
 *     ModuleDTO:
 *       type: "object"
 *       properties:
 *         id:
 *           type: "string"
 *         url:
 *           type: "string"
 *
 *     ModuleType:
 *       type: string
 *       enum:
 *         - jar
 *         - docker
 */
