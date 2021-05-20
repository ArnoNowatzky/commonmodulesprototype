package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DockerInstallerTest {

  public static void main(String[] args) throws IOException {
    File tmpDir = Files.createTempDirectory(DockerInstallerTest.class.getName()).toFile();
    DockerInstaller dockerInstaller = new DockerInstaller();

    CommonModule commonModule = new CommonModule();
    commonModule.setId("service");
    dockerInstaller.getState(tmpDir, commonModule);
  }
}
