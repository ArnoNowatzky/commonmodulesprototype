package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.model.SetupModulesParamDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ModuleControllerTest {

  @Autowired
  private ModuleController moduleController;

  @BeforeEach
  /**public void cleanUp () throws IOException {
    File examplePath = new File ("build/example");
    if (examplePath.exists())
      FileUtils.deleteDirectory(examplePath);
  }**/

  @Test
  public void installStartAndStop () throws IOException {

    InputStream inputStream = getClass().getResourceAsStream("/testinstall.xml");
    StringWriter stringWriter = new StringWriter();
    IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

    String descriptor = stringWriter.toString();
    descriptor = descriptor.replace("~", System.getProperty("user.home"));
    SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().path("build/example").descriptor(descriptor);

    moduleController.installModules(setupModulesParamDTO);
    moduleController.startModules(setupModulesParamDTO);
  }
}
