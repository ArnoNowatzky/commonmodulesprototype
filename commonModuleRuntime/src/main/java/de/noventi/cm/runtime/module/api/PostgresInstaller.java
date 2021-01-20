package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostgresInstaller implements Installer{

  @Autowired JdbcTemplate jdbcTemplate;

  @Override public void install(File path, CommonModule module) {
    log.info ("Create database " + module.getId());

    String query="CREATE DATABASE " + module.getId();
    try {
      int result = jdbcTemplate.update(query);
      log.info("...result " + result);
    } catch (Exception e) {
      log.error("Exception on creating database " + module.getId() + ":" + e.getLocalizedMessage(), e);

    }


  }

  @Override public void start(File path, CommonModule module) {

  }

  @Override public void stop(File path, CommonModule module) {

  }
}
