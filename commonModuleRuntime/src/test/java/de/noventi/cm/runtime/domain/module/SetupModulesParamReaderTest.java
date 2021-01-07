package de.noventi.cm.runtime.domain.module;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SetupModulesParamReaderTest {

  @Test
  public void readModules () throws IOException {

    InputStream inputStream = getClass().getResourceAsStream("/testinstall.xml");
    StringWriter stringWriter = new StringWriter();
    IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

    String descriptor = stringWriter.toString();

    SetupModulesParamReader setupModulesParamReader = new SetupModulesParamReader();
    CommonModules commonModules = setupModulesParamReader.read(descriptor);
    Assertions.assertEquals (1, commonModules.getCommonModule().size(), "Wrong number of modules");
    CommonModule commonModule1 = commonModules.getCommonModule().get(0);
    Assertions.assertEquals("service", commonModule1.getId(), "Id invalid");
    Assertions.assertEquals("CustomerService", commonModule1.getName(), "Name invalid");
    Assertions.assertEquals("http://repo.intra.vsa.de:8082/artifactory/awinta-maven/de/noventi/cm/service/0.1/service-0.1.jar", commonModule1
        .getUrl(), "URL invalid");
    Assertions.assertEquals(Type.JAR, commonModule1.getType(), "Type invalid");
    Assertions.assertEquals(Action.INSTALL, commonModule1.getAction(), "Action invalid");

  }
}
