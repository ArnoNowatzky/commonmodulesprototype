package de.noventi.cm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ServiceApplication {

  public static void main (final String [] args) {
    SpringApplication.run(ServiceApplication.class, args);
  }

}
