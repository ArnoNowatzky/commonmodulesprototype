package de.noventi.cm.runtime.api;

import de.noventi.cm.runtime.model.SetupModulesParamDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

public class ModuleControllerTest {

  @Test
  public void installStartAndStop () throws IOException {

    InputStream inputStream = getClass().getResourceAsStream("/testinstall.xml");
    StringWriter stringWriter = new StringWriter();
    IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

    String descriptor = stringWriter.toString();
    descriptor = descriptor.replace("~", System.getProperty("user.home"));
    SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().path("build/example").descriptor(descriptor);

    ModuleController moduleController = new ModuleController();
    moduleController.installModules(setupModulesParamDTO);
    moduleController.startModules(setupModulesParamDTO);
  }
}
