package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.Download;
import de.noventi.cm.runtime.module.domain.Unzip;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JdkInstaller implements Installer {

  @Value("${jdks}")
  private List<String> jdks;

  private String os;

  private Download download = new Download();


  public JdkInstaller () {
    if (SystemUtils.IS_OS_WINDOWS)
      os = "windows";
    else if (SystemUtils.IS_OS_LINUX)
      os = "linux";
    else
      os = "macosx";
  }

  private HashMap<String, String> getJdkPerVersion () {
    final HashMap<String, String> jdkPerVersion = new HashMap<>();
    for (String nextJdk: jdks) {
      String [] tokens = nextJdk.split("@");
      jdkPerVersion.put(tokens[0], tokens[1].replace("#OS#", os));
    }
    return jdkPerVersion;
  }

  @Override public void install(File path, CommonModule module) {
    if (module.getJdk() == null) {
      log.info("No jdk defined for module " + module.getId());
      return;
    }

    log.info("Installation of jdk " + module.getJdk());

    HashMap<String, String> jdkPerVersion = getJdkPerVersion();

    File jdkPath = new File (path, module.getJdk());

    String url = jdkPerVersion.get(module.getJdk());
    if (url == null)
      throw new IllegalArgumentException("No jdk found for <" + module.getJdk() + ", the following jdks can be handled: " + jdkPerVersion + ">");

    if (! jdkPath.exists()) {
      log.info("Download of jdk " + url + " to " + jdkPath + "...");
      File downloadedJdkZip = this.download.download(jdkPath, url); //TODO use jre
      try {
        log.info("Unzipping of jdk " + url + " to " + jdkPath + "...");
        Unzip.unzipFileIntoDirectory(new ZipFile(downloadedJdkZip), jdkPath);
      } catch (IOException e) {
        throw new IllegalStateException("File " + downloadedJdkZip.getAbsolutePath() + " does not seem to be a zipfile");
      }

    }
    else
      log.info("Jdk installation path " + jdkPath.getAbsolutePath() + " already exists");

    log.info("Installation of jdk " + module.getJdk() + " finished");
  }

  @Override public void start(File path, CommonModule module) {
    throw new IllegalStateException("JDK installer does not contain a start implementation");
  }

  @Override public void stop(File path, CommonModule module) {
    throw new IllegalStateException("JDK installer does not contain a stop implementation");
  }

  public File getHome (final File unzipPath) {
    if (SystemUtils.IS_OS_WINDOWS) {
      return unzipPath;
    }
    else if (SystemUtils.IS_OS_LINUX) {
      throw new IllegalStateException("Not yet implemented");
    }
    else {
      return new File (unzipPath, "Contents/Home");
    }

  }

  public File getJreExecutable(final File javaHome)  {
    File exe;
    if (SystemUtils.IS_OS_WINDOWS) {
      exe = new File(javaHome, "bin/java.exe");
    } else {
      exe = new File(javaHome, "bin/java");
    }
    if (!exe.isFile()) {
      throw new IllegalStateException("Jre bin file not available: " + exe.toString());
    }
    return exe;
  }

  @Override public ModuleStatus getState(File path, CommonModule module) {
    ModuleStatus moduleStatus = new ModuleStatus();
    return moduleStatus;
  }

}
