package de.noventi.cm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan
@EntityScan(basePackages = { "de.noventi.cm.service.db" })
@EnableScheduling
@Slf4j
public class ServiceApplication {

  public static void main (final String [] args) {
    log.info("Application Pid: " + new File("application.pid").getAbsoluteFile().getAbsolutePath());
    SpringApplication springApplication = new SpringApplication(ServiceApplication.class);
    springApplication.addListeners(new ApplicationPidFileWriter());
    springApplication.run(args);
  }

}
