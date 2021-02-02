package de.noventi.cm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan
@EnableScheduling
@Slf4j
public class RuntimeApplication {

  public static void main(final String[] args) {
    SpringApplication.run(RuntimeApplication.class, args);
  }



}
