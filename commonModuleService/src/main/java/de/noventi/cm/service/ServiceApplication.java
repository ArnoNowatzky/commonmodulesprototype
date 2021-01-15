package de.noventi.cm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ServiceApplication {

  public static void main (final String [] args) {
    SpringApplication springApplication = new SpringApplication(ServiceApplication.class);
    springApplication.addListeners(new ApplicationPidFileWriter());
    springApplication.run(args);
  }

}
