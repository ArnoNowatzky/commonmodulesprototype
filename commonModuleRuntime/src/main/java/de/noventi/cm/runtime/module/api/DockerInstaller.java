package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import de.noventi.cm.runtime.module.domain.Download;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
    log.info("Install module " + module.getId() + " in path " + path.getAbsolutePath());
  }

  @Override public void start(File path, CommonModule module) {
    log.info("Start module " + module.getId() + " in path " + path.getAbsolutePath());

    File modulePath = new File (path, module.getId());
    List<String> cmdarray = new ArrayList<String>();
    cmdarray.add("docker-compose");
    cmdarray.add("up");
    cmdarray.add("--detach");

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
        System.out.write(buffer, 0, r);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }




  }

  @Override public void stop(File path, CommonModule module) {
    log.info("Stop module " + module.getId() + " in path " + path.getAbsolutePath());

    File modulePath = new File (path, module.getId());
    List<String> cmdarray = new ArrayList<String>();
    cmdarray.add("docker-compose");
    cmdarray.add("down");
    cmdarray.add("--detach");

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
        System.out.write(buffer, 0, r);
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }

}
