package de.noventi.cm.example.api;

import de.noventi.cm.example.db.Medication;
import de.noventi.cm.example.db.MedicationContainer;
import de.noventi.cm.example.model.MedicationDTO;
import de.noventi.cm.example.model.MedicationcontainerDTO;

public class MedicationcontainerMapper {

  public MedicationcontainerDTO toMedicationcontainerDTO (final MedicationContainer medicationContainer) {
    MedicationcontainerDTO medicationcontainerDTO = new MedicationcontainerDTO();
    medicationcontainerDTO.setId(medicationContainer.getId());
    medicationcontainerDTO.setConsumerId(medicationContainer.getConsumerId());
    medicationcontainerDTO.setConsumerName(medicationContainer.getConsumerName());
    medicationcontainerDTO.setConsumerFirstname(medicationContainer.getConsumerFirstname());
    if (medicationContainer.getMedications() != null) {
      for (Medication next : medicationContainer.getMedications()) {
        medicationcontainerDTO.addMedicationsItem(toMedicationDTO(next));
      }
    }

    return medicationcontainerDTO;
  }

  public MedicationDTO toMedicationDTO (final Medication medication) {
    MedicationDTO addressDTO = new MedicationDTO();
    addressDTO.setId(medication.getId());
    addressDTO.setName(medication.getName());
    addressDTO.setPharmacode(medication.getPharmacode());
    return addressDTO;
  }


}
