package de.noventi.cm.wawi.java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan
@Slf4j
public class WawiServerApplication {

  public static void main(final String[] args) {
    SpringApplication.run(WawiServerApplication.class, args);
  }
}
