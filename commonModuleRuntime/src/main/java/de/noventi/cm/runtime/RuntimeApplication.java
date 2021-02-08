package de.noventi.cm.runtime;

import de.noventi.cm.runtime.jwt.config.KeycloakServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class) //TODO due to keycloak
@EnableConfigurationProperties(KeycloakServerProperties.class)
@ComponentScan
@EnableScheduling
@Slf4j
public class RuntimeApplication {

  public static void main(final String[] args) {
    SpringApplication.run(RuntimeApplication.class, args);
  }

  @Bean ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties, KeycloakServerProperties keycloakServerProperties) {

    return (evt) -> {

      Integer port = serverProperties.getPort();
      String keycloakContextPath = keycloakServerProperties.getContextPath();

      log.info("Embedded Keycloak started: http://localhost:{}{} to use keycloak", port, keycloakContextPath);
    };
  }

}
