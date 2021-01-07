package de.noventi.cm.runtime.api;

import de.noventi.cm.runtime.domain.module.CommonModule;
import de.noventi.cm.runtime.domain.module.CommonModules;
import de.noventi.cm.runtime.domain.module.SetupModulesParamReader;
import de.noventi.cm.runtime.domain.module.Type;
import de.noventi.cm.runtime.model.SetupModulesParamDTO;
import io.swagger.annotations.ApiParam;
import java.io.File;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ModuleController implements ModuleApi{

  private SetupModulesParamReader setupModulesParamReader = new SetupModulesParamReader();

  @Override
  public ResponseEntity<Void> installModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    log.info("called setupModules <" + setupModulesParamDTO + ">");
    CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());
    File path = new File (setupModulesParamDTO.getPath());

    for (CommonModule next: commonModules.getCommonModule()) {
      log.info("Install module " + next);
      if (next.getType().equals(Type.JAR)) { //TODO generalize
        JarInstaller jarInstaller = new JarInstaller();
        jarInstaller.install(path, next);
      }
    }

    return new ResponseEntity<Void>( HttpStatus.OK );
  }

  @Override
  public ResponseEntity<Void> startModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody SetupModulesParamDTO setupModulesParamDTO) {
    log.info("called setupModules <" + setupModulesParamDTO + ">");
    CommonModules commonModules = setupModulesParamReader.read(setupModulesParamDTO.getDescriptor());
    File path = new File (setupModulesParamDTO.getPath());
    for (CommonModule next: commonModules.getCommonModule()) {
      log.info("Start module " + next);
      if (next.getType().equals(Type.JAR)) { //TODO generalize
        JarInstaller jarInstaller = new JarInstaller();
        jarInstaller.start(path, next);
      }
    }
    return new ResponseEntity<Void>( HttpStatus.OK );
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
