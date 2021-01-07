package de.noventi.cm.runtime.api;

import de.noventi.cm.runtime.domain.module.CommonModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

@Slf4j
public class JarInstaller implements Installer {

  @Override
  public void install (File path, CommonModule module) {
    if (module.getId() == null)
      throw new IllegalArgumentException("Module " + module + " must contain id");

    log.info("Install module " + module.getId() + " in path " + path.getAbsolutePath());

    File modulePath = new File (path, module.getId());

    File binPath = new File (modulePath, "bin");
    if (! binPath.exists()) {
      binPath.mkdirs();
      String url = module.getUrl();
      String [] urlTokens = url.split("/");
      String filename = urlTokens[urlTokens.length - 1];
      try {
        FileOutputStream fos = new FileOutputStream(new File (binPath, filename));
        URL installUrl = new URL (url);
        log.info("SourceLocation: " + installUrl.toString());
        IOUtils.copy(installUrl.openStream(), fos);
      } catch (IOException e) {
        log.error("Error creating outputstream of jar :" + e.getLocalizedMessage(), e);
      }

    }




  }

  @Override public void start(File path, CommonModule module) {
    log.info("Start module " + module.getId() + " in path " + path.getAbsolutePath());

  }
}
