package de.noventi.cm.hello;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@Slf4j
public class HelloWorldApplication {

  public static void main (final String [] args) {
    log.info("Application Pid: " + new File("application.pid").getAbsoluteFile().getAbsolutePath());
    SpringApplication springApplication = new SpringApplication(HelloWorldApplication.class);
    springApplication.addListeners(new ApplicationPidFileWriter());
    springApplication.run(args);
  }

}
