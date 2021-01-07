package de.noventi.cm.runtime.api;

import de.noventi.cm.runtime.domain.module.CommonModule;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JarInstallerTest {

  @Test
  public void install () throws IOException {

    File origin = new File("src/test/resources/testinstall.xml");
    URL fileUrl = origin.toURI().toURL();

    CommonModule commonModule = new CommonModule();
    commonModule.setUrl(fileUrl.toString());
    commonModule.setId("service");

    File tmpDir = Files.createTempDirectory(getClass().getName()).toFile();
    JarInstaller jarInstaller = new JarInstaller();
    jarInstaller.install(tmpDir, commonModule);
    File downloadedFile = new File (tmpDir, "service/bin/testinstall.xml");
    Assertions.assertTrue (downloadedFile.exists(), "Destination file " + downloadedFile.getAbsolutePath() + " not available");
    Assertions.assertEquals (downloadedFile.length(), origin.length(), "Length of " + downloadedFile.getAbsolutePath() + " invalid" );
  }
}
