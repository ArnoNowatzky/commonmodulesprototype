package de.noventi.cm.runtime.module.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

@Slf4j
public class Download {

  public File download (final File toDir, final String url) {
    if (! toDir.exists())
      toDir.mkdirs();

    String [] urlTokens = url.split("/");
    String filename = urlTokens[urlTokens.length - 1];
    try {
      File outputFile = new File (toDir, filename);
      if (! outputFile.exists()) {
        log.info("Download " + url + " to " + outputFile.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(outputFile);
        URL installUrl = new URL(url);
        IOUtils.copy(installUrl.openStream(), fos);

        /**if (outputFile.length() == 0) {
          outputFile.delete();
          throw new IllegalStateException("Could not download file " + url);
        }**/
      }
      else
        log.info(outputFile.getAbsolutePath() + " already exists, skip download");
      return outputFile;
    } catch (IOException e) {
      throw new IllegalStateException("Error creating outputstream of jar :" + e.getLocalizedMessage(), e);
    }
  }
}
