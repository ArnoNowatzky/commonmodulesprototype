package de.noventi.cm.runtime.api;

import de.noventi.cm.runtime.model.ModuleDTO;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ModuleController implements ModuleApi{

  public ModuleController () {
    log.info("Create " + getClass().getName());
  }

  public ResponseEntity<Void> setupModules(@ApiParam(value = "modules descriptor" ,required=true )  @Valid @RequestBody String body) {
    log.info("called setupModules <" + body + ">");

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
