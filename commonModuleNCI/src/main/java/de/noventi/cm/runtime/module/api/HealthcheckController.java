package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.api.HealthcheckApi;
import de.noventi.cm.runtime.model.HealthcheckDTO;
import de.noventi.cm.runtime.monitoring.MonitoringData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthcheckController implements HealthcheckApi {

  public ResponseEntity<HealthcheckDTO> healthcheck() {
    HealthcheckDTO healthcheckDTO = new HealthcheckDTO();
    healthcheckDTO.setMonitoring(new MonitoringData().toString());

    return ResponseEntity.ok(healthcheckDTO);
  }
}
