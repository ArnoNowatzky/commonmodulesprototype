package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.Download;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DockerInstaller implements Installer {

  @Override
  public void install (File path, CommonModule module) {
    if (module.getId() == null)
      throw new IllegalArgumentException("Module " + module + " must contain id");
    log.info("Install module " + module.getId() + " with description " + module.getDescription());

    File modulePath = new File (path, module.getId());
    modulePath.mkdirs();

    String description = module.getDescription();
    File dockerCompose = new File (modulePath, "docker-compose.yml");
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(dockerCompose));
      writer.write(description);

    } catch (IOException e) {
      throw new IllegalStateException("Error installing module " + module.getId(), e);
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          throw new IllegalStateException(e);
        }
      }
    }
    log.info("Install module " + module.getId() + " in path " + path.getAbsolutePath() + " finished");
  }

  @Override public void start(File path, CommonModule module) {
    File modulePath = new File (path, module.getId());
    log.info("Start module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath());

    List<String> cmdarray = new ArrayList<String>();
    cmdarray.add("docker-compose");
    cmdarray.add("up");
    cmdarray.add("--detach");

    log.info("- Commandline: " + cmdarray);

    ProcessBuilder processBuilder = new ProcessBuilder(cmdarray);
    processBuilder.directory(modulePath);
    processBuilder.inheritIO();
    processBuilder.redirectOutput();
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
        System.out.write(buffer, 0, r);
      }

      int returncode = process.waitFor();
      log.info("Start module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + " finished with returncode " + returncode);
      if (returncode != 0) {
        String text = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8)).lines().collect(
            Collectors.joining("\n"));
        log.error("Error when starting module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + ":" + text);
      }
    } catch (IOException | InterruptedException e) {
      throw new IllegalStateException(e);
    }


    log.info("Start module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + " finished");




  }

  @Override public void stop(File path, CommonModule module) {

    File modulePath = new File (path, module.getId());
    log.info("Stop module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath());

    List<String> cmdarray = new ArrayList<String>();
    cmdarray.add("docker-compose");
    cmdarray.add("down");

    log.info("- Commandline: " + cmdarray);

    ProcessBuilder processBuilder = new ProcessBuilder(cmdarray);
    processBuilder.directory(modulePath);
    processBuilder.inheritIO();
    processBuilder.redirectOutput();
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
        System.out.write(buffer, 0, r);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

    log.info("Stop module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + "finished");

  }

  @Override public ModuleStatus getState(File path, CommonModule module) {
    ModuleStatus moduleStatus = new ModuleStatus();
    File modulePath = new File (path, module.getId());
    log.info("Get state of module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath());



    moduleStatus.setRunning(true);
    moduleStatus.setInstanceId("TODO");

    log.info("Get state of module " + module.getId() + " in modulepath " + modulePath.getAbsolutePath() + "finished");

    return moduleStatus;
  }

}
