package de.noventi.cm.example.api;

import de.noventi.cm.example.db.MedicationContainer;
import de.noventi.cm.example.db.MedicationContainerRepository;
import de.noventi.cm.example.model.MedicationcontainerDTO;
import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //TODO
@Slf4j
public class MedicationcontainersController implements MedicationcontainersApi{

  @Value("${spring.datasource.url}")
  private String datasourceUrl;

  @Autowired
  private MedicationContainerRepository medicationContainerRepository;

  private MedicationcontainerMapper medicationcontainerMapper = new MedicationcontainerMapper();

  public MedicationcontainersController() {
    log.info("Create CustomerController");
  }

  @Override
  public ResponseEntity<List<MedicationcontainerDTO>> findMedicationContainersByConsumer(@ApiParam(value = "",required=true) @PathVariable("consumerId") String consumerId) {
    log.info("called findMedicationContainersByConsumer");
    log.info("- url: " + datasourceUrl);

    Iterable<MedicationContainer> iterable = medicationContainerRepository.findByConsumerId(consumerId);
    List<MedicationcontainerDTO> result = new ArrayList<>();
    for (MedicationContainer next: iterable) {
      result.add(medicationcontainerMapper.toMedicationcontainerDTO(next));
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<MedicationcontainerDTO> getMedicationContainer(@ApiParam(value = "",required=true) @PathVariable("containerId") String containerId) {
    long currentTime = System.currentTimeMillis();
    log.info("called getMedicationContainer " + containerId);

    Optional<MedicationContainer> byId = medicationContainerRepository.findById(containerId);
    if (byId.isPresent()) {
      long duration = System.currentTimeMillis() - currentTime;
      log.info("Found medication container " + byId.get().getId() + "(" + duration + " ms)");
      return ResponseEntity.ok(medicationcontainerMapper.toMedicationcontainerDTO(byId.get()));
    }
    else {
      log.error("No medication container found for id " + containerId);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @Override
  public ResponseEntity<List<MedicationcontainerDTO>> getMedicationContainers() {
    log.info("called getMedicationContainers");
    log.info("- url: " + datasourceUrl);

    Iterable<MedicationContainer> iterable = medicationContainerRepository.findAll();
    List<MedicationcontainerDTO> result = new ArrayList<>();
    for (MedicationContainer next: iterable) {
      result.add(medicationcontainerMapper.toMedicationcontainerDTO(next));
    }
    log.info("Return " + result);
    return ResponseEntity.ok(result);
  }

  public ResponseEntity<Void> updateMedicationContainer(@ApiParam(value = "",required=true) @PathVariable("containerId") String containerId,@ApiParam(value = "updated container" ,required=true )  @Valid @RequestBody MedicationcontainerDTO medicationcontainerDTO) {
    //TODO
    return null;
  }


}
