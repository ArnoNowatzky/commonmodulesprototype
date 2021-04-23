package de.noventi.cm.example;

import de.noventi.cm.example.db.Medication;
import de.noventi.cm.example.db.MedicationContainer;
import de.noventi.cm.example.db.MedicationContainerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestDataCreator {

  @Autowired
  private MedicationContainerRepository medicationContainerRepository;

  public void create () {
    List<MedicationContainer> medicationContainerList = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {

      MedicationContainer medicationContainer = new MedicationContainer();
      medicationContainer.setId(Integer.toString(i));
      medicationContainer.setConsumerId("Holmes " + i);
      medicationContainer.setConsumerName("Holmes " + i);
      medicationContainer.setConsumerFirstname("Sherlock " + i);

      List<Medication> medications = new ArrayList<>();
      Medication medication1 = new Medication();
      medication1.setId(UUID.randomUUID().toString());
      medication1.setName("RULID 300");
      medication1.setPharmacode("04462016");
      medications.add(medication1);
      Medication medication2 = new Medication();
      medication2.setId(UUID.randomUUID().toString());
      medication2.setName("SIMVA ARISTO 40MG");
      medication2.setPharmacode("09900751");
      medications.add(medication2);

      medicationContainerList.add(medicationContainer);

    }

    log.info("Creating "+ medicationContainerList.size() + " medicationcontainers for test");
    medicationContainerRepository.deleteAll();
    medicationContainerRepository.saveAll(medicationContainerList);
  }
}
