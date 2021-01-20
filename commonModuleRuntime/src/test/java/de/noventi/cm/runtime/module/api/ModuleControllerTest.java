package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.model.SetupModulesParamDTO;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModuleControllerTest {

  @Autowired
  private ModuleController moduleController;

  /**@Test  TODO make integration test
public void installJar () throws IOException {
    String descriptor = FileUtils.readFileToString(new File("src/test/resources/testinstall.xml"), Charset.defaultCharset());
    SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO();
    setupModulesParamDTO.setPath("build/junit/ModuleControllerTest_installJar");
    setupModulesParamDTO.setDescriptor(descriptor);
    moduleController.installModules(setupModulesParamDTO);
  }**/
}
