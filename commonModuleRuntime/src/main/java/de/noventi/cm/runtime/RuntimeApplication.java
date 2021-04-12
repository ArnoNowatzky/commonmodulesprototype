package de.noventi.cm.runtime;

import de.noventi.cm.runtime.monitoring.MonitoringData;
import de.noventi.cm.runtime.monitoring.MonitoringRuntime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class) //TODO due to keycloak
@ComponentScan
@EnableScheduling
@Slf4j
public class RuntimeApplication {

  public static void main(final String[] args) {
    SpringApplication.run(RuntimeApplication.class, args);
    MonitoringData monitoringData = new MonitoringData();
    log.info(monitoringData.toString());
  }


}
