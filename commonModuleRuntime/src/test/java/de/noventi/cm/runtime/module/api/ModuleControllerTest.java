package de.noventi.cm.runtime.module.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModuleControllerTest {

  @Autowired
  private ModulesController modulesController;

  /**@Test  TODO make integration test
public void installJar () throws IOException {
    String descriptor = FileUtils.readFileToString(new File("src/test/resources/testinstall.xml"), Charset.defaultCharset());
    SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO();
    setupModulesParamDTO.setPath("build/junit/ModuleControllerTest_installJar");
    setupModulesParamDTO.setDescriptor(descriptor);
    moduleController.installModules(setupModulesParamDTO);
  }**/
}
