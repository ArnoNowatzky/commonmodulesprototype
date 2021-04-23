package de.noventi.cm.example.db;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MedicationContainerRepository extends CrudRepository<MedicationContainer, String> {

  List<MedicationContainer> findByConsumerId (final String consumerId);
}
