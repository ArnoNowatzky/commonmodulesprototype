package de.noventi.cm.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class UiApplication {

  public static void main (final String [] args) {
    SpringApplication.run(UiApplication.class, args);
  }

}
