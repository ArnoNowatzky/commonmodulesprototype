package de.noventi.cm.wawi.java.api;

import de.noventi.cm.wawi.api.PharmacyApi;
import de.noventi.cm.wawi.model.PharmacyDTO;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*") //TODO
@RestController
public class PharmacyController implements PharmacyApi {


  public PharmacyController () {
    log.info("Creating " + PharmacyController.class);
  }

  public ResponseEntity<PharmacyDTO> getPharmacyInfo() {

    PharmacyDTO pharmacyDTO = new PharmacyDTO();
    pharmacyDTO.setApoNr("12345");
    pharmacyDTO.setBgaNr(Arrays.asList("912485123", "128712874"));
    pharmacyDTO.setInhaber("Dr. No");
    pharmacyDTO.setName("Common Module Apo");
    pharmacyDTO.setIkNr(Arrays.asList("1234567", "7654321"));

    return ResponseEntity.ok(pharmacyDTO);

  }
}
