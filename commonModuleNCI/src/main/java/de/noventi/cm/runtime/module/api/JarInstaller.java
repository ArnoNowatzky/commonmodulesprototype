package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.Download;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j @Component public class JarInstaller implements Installer {

  @Autowired JdkInstaller jdkInstaller;

  private Download download = new Download();

  @Override public void install(File path, CommonModule module) {
    if (module.getId() == null)
      throw new IllegalArgumentException("Module " + module + " must contain id");

    File modulePath = new File(path, module.getId());

    log.info("Install module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath());

    File binPath = new File(modulePath, "bin");
    String url = module.getUrl();
    download.download(binPath, url);

    jdkInstaller.install(path, module);

    log.info("Install module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + " finished");


  }

  @Override public void start(File path, CommonModule module) {
    File jdkPath = new File(path, module.getJdk());

    File folder = getSingleFolder(jdkPath);

    File modulePath = new File(path, module.getId());
    log.info("Start module " + module.getId() + " in modulepath " + path.getAbsolutePath());

    File binPath = new File(modulePath, "bin");

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
        System.out.println("->" + module.getId() + " " + line);

      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

    log.info("Start module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + " finished");


  }

  @Override public void stop(File path, CommonModule module) {
    File modulePath = new File(path, module.getId());
    log.info("Stop module " + module.getId() + " in modulepath " + path.getAbsolutePath());

    File applicationPidFile = new File(modulePath, "application.pid");
    if (applicationPidFile.exists()) {
      try {
        String pid = FileUtils.readFileToString(applicationPidFile, Charset.defaultCharset());
        log.info("Shutdown service " + path.getName() + " with pid " + pid);

        try {

          int returnCode = 0;
        if (SystemUtils.IS_OS_WINDOWS) {
          returnCode = Runtime.getRuntime().exec("taskkill /F /T /PID " + pid).waitFor();
          if (applicationPidFile.exists())
            applicationPidFile.delete();
        } else {
          returnCode = Runtime.getRuntime().exec("kill " + pid).waitFor();
        }
        log.info("Killing task exited with returncode " + returnCode);

        } catch (InterruptedException e) {
          log.error("Error killing process with pid " + pid);
          throw new IllegalStateException(e);
        }

      } catch (IOException e) {
        log.error("Error reading application pid file " + applicationPidFile.getAbsolutePath());
        throw new IllegalStateException(e);
      }
    } else
      log.warn("Module in modulepath " + modulePath.getAbsolutePath() + " does not contain a pidfile " + applicationPidFile.getAbsolutePath());

    log.info("Stop module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + " finished");



  }

  @Override public ModuleStatus getState (File path, CommonModule module) {
    File modulePath = new File(path, module.getId());
    log.info("Get state of module " + module.getId() + " in modulepath " + path.getAbsolutePath());

    File applicationPidFile = new File(modulePath, "application.pid");
    ModuleStatus moduleStatus = new ModuleStatus();
    if (applicationPidFile.exists()) {
      try {
        moduleStatus.setRunning(true);
        moduleStatus.setInstanceId(FileUtils.readFileToString(applicationPidFile, Charset.defaultCharset()));
      } catch (IOException e) {
        log.error("Error reading application pid file " + applicationPidFile.getAbsolutePath());
        throw new IllegalStateException(e);
      }
    }
    log.info("Get state of module " + module.getId() + " in modulepath " + path.getAbsolutePath() + " finished");

    return moduleStatus;
  }

  private File getSingleFolder(final File inPath) {
    if (inPath.listFiles() == null)
      throw new IllegalStateException("No entry found in " + inPath.getAbsolutePath());
    for (File next : inPath.listFiles()) {
      if (next.isDirectory())
        return next;
    }

    throw new IllegalStateException("No folder found in " + inPath.getAbsolutePath());
  }

  private File getSingleFile(final File inPath) {
    if (inPath.listFiles() == null)
      throw new IllegalStateException("No entry found in " + inPath.getAbsolutePath());
    for (File next : inPath.listFiles()) {
      if (!next.isDirectory())
        return next;
    }

    throw new IllegalStateException("No folder found in " + inPath.getAbsolutePath());
  }

}
