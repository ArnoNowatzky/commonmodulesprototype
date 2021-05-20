package de.noventi.cm.client.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class PerformanceTest {

  private static File autoprotoPath = new File ("build/performance");

  @BeforeAll
  public static void beforeClass () {
    FileUtils.deleteQuietly(autoprotoPath);
  }

  private Process executeProcess (final String uuid, final File collectData) throws IOException {

    String javaHome = System.getProperty("java.home");
    String javaBin = javaHome + File.separator + "bin" +File.separator + "java";
    String classpath = System.getProperty("java.class.path");
    String className = AutomaticClient.class.getName();

    List<String> args = new ArrayList<>();
    args.add(uuid);
    args.add(collectData.getAbsolutePath());
    List<String> command = new LinkedList<String>();
    command.add(javaBin);
    command.add("-cp");
    command.add(classpath);
    command.add(className);
    if (args != null) {
      command.addAll(args);
    }

    ProcessBuilder builder = new ProcessBuilder(command);

    Process process = builder.inheritIO().start();
    log.info("Start client " + process.pid());
    return process;

  }

  @Test
  public void localServiceCall10Clients () throws IOException, InterruptedException {
    serviceCallLocalPharmacy(10,"serviceCallLocal10Clients");
  }

  @Test
  public void localServiceCall50Clients () throws IOException, InterruptedException {
    serviceCallLocalPharmacy(50,"serviceCallLocal50Clients");
  }

  private void serviceCallLocalPharmacy (final int numberOfClient, final String name) throws IOException, InterruptedException {

    File performanceCase = new File (autoprotoPath, name);

    List<Process> processes = new ArrayList<>();

    String uuid = UUID.randomUUID().toString();

    for (int i = 0; i < numberOfClient; i++) {
      processes.add(executeProcess( uuid, new File (autoprotoPath, name)));
    }

    boolean atLeastOneIsAlive = true;

    while (atLeastOneIsAlive) {
      atLeastOneIsAlive = false;
      for (Process next: processes) {
        log.info("Process " + next.pid() + "->" + next.isAlive());
        if (next.isAlive())
          atLeastOneIsAlive = true;
      }
      Thread.sleep(1000);
    }

    int numberOfErrors = 0;
    for (Process next: processes) {
      if (next.exitValue() != 0)
        numberOfErrors ++;
    }

    Assertions.assertEquals(0, numberOfErrors, "Number of occurred errors invalid");

    CreateDiagram createDiagram = new CreateDiagram();
    createDiagram.createDiagram(performanceCase);



  }
}
