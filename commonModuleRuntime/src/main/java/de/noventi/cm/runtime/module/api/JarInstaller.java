package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.Download;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JarInstaller implements Installer {

  @Autowired
  private JdkInstaller jdkInstaller;

  private Download download = new Download();

  @Override
  public void install (File path, CommonModule module) {
    if (module.getId() == null)
      throw new IllegalArgumentException("Module " + module + " must contain id");

    log.info("Install module " + module.getId() + " in path " + path.getAbsolutePath());

    File modulePath = new File (path, module.getId());

    File binPath = new File (modulePath, "bin");
    if (! binPath.exists()) {
      String url = module.getUrl();
      download.download(binPath, url);

      jdkInstaller.install(path, module);
    }
    else
      log.info(" Path " + binPath.getAbsolutePath() + " already exists, skip installation of module " + module.getId());
  }

  @Override public void start(File path, CommonModule module) {
    log.info("Start module " + module.getId() + " in path " + path.getAbsolutePath());
    File jdkPath = new File (path, module.getJdk());

    File folder = getSingleFolder(jdkPath);

    File modulePath = new File (path, module.getId());
    File binPath = new File (modulePath, "bin");

    File javaHome = jdkInstaller.getHome(folder);
    File javaBin = jdkInstaller.getJreExecutable(javaHome);

    List<String> cmdarray = new ArrayList<String>();
    javaBin.setExecutable(true);
    cmdarray.add(javaBin.getAbsolutePath());
    cmdarray.add("-jar");
    cmdarray.add(getSingleFile(binPath).getAbsolutePath());
    log.info("-" + cmdarray);

    ProcessBuilder processBuilder = new ProcessBuilder(cmdarray);
    processBuilder.directory(modulePath);
    processBuilder.redirectErrorStream(true);
    Process process = null;
    byte[] buffer = new byte[1024];

    try {
      process = processBuilder.start();
      InputStream in = process.getInputStream();
      while (true) {
        int r = in.read(buffer);
        if (r <= 0) {
          break;
        }
        String line = new String(buffer);
        System.out.println ("->" + module.getId() + " " + line);

      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }


  }




  private File getSingleFolder (final File inPath) {
    if (inPath.listFiles() == null)
      throw new IllegalStateException("No entry found in " + inPath.getAbsolutePath());
    for (File next: inPath.listFiles()) {
      if (next.isDirectory())
        return next;
    }

    throw new IllegalStateException("No folder found in " + inPath.getAbsolutePath());
  }

  private File getSingleFile (final File inPath) {
    if (inPath.listFiles() == null)
      throw new IllegalStateException("No entry found in " + inPath.getAbsolutePath());
    for (File next: inPath.listFiles()) {
      if (! next.isDirectory())
        return next;
    }

    throw new IllegalStateException("No folder found in " + inPath.getAbsolutePath());
  }


}
