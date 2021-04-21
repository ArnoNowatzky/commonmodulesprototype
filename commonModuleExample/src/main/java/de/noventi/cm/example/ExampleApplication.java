package de.noventi.cm.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "de.noventi.cm")
@EntityScan(basePackages = { "de.noventi.cm.example.db" })
@EnableScheduling
@Slf4j
public class ExampleApplication {

  public ExampleApplication(@Autowired final TestDataCreator testDataCreator) {
    testDataCreator.create();
  }

  public static void main (final String [] args) {
    log.info("Application Pid  : " + new File("application.pid").getAbsoluteFile().getAbsolutePath());
    log.info("Arguments        : " + String.join(" ", args));
    log.info("Environment      : " + System.getenv());
    SpringApplication springApplication = new SpringApplication(ExampleApplication.class);
    springApplication.addListeners(new ApplicationPidFileWriter());
    springApplication.run(args);
  }

}
