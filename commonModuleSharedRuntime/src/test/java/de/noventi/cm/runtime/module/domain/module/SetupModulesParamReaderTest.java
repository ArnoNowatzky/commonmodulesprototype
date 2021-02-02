package de.noventi.cm.runtime.module.domain.module;

import de.noventi.cm.runtime.module.domain.Action;
import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.CommonModules;
import de.noventi.cm.runtime.module.domain.SetupModulesParamReader;
import de.noventi.cm.runtime.module.domain.Type;
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

    String url = "file://" + System.getProperty("user.home") + "/.m2/repository/de/noventi/cm/service/0.1-SNAPSHOT/service-0.1-SNAPSHOT.jar";

    SetupModulesParamReader setupModulesParamReader = new SetupModulesParamReader();
    CommonModules commonModules = setupModulesParamReader.read(descriptor);
    Assertions.assertEquals (1, commonModules.getCommonModule().size(), "Wrong number of modules");
    CommonModule commonModule1 = commonModules.getCommonModule().get(0);
    Assertions.assertEquals("service", commonModule1.getId(), "Id invalid");
    Assertions.assertEquals("CustomerService", commonModule1.getName(), "Name invalid");
    Assertions.assertEquals(url, commonModule1.getUrl(), "URL invalid");
    Assertions.assertEquals(Type.JAR, commonModule1.getType(), "Type invalid");
    Assertions.assertEquals(Action.INSTALL, commonModule1.getAction(), "Action invalid");

  }
}
