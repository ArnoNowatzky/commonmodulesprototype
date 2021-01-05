package de.noventi.cm.service.api;

import de.noventi.cm.service.model.AddressDTO;
import de.noventi.cm.service.model.CustomerDTO;
import de.noventi.cm.service.model.PhoneDTO;
import io.swagger.annotations.ApiParam;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController implements CustomerApi{

  private CustomerDTO getCustomer () {
    PhoneDTO phone1 = new PhoneDTO();
    phone1.setPhonetype("PRIVAT");
    phone1.setNumber("+491234567890");

    PhoneDTO phone2 = new PhoneDTO();
    phone2.setPhonetype("WORK");
    phone2.setNumber("+4998765432");

    AddressDTO addressDTO = new AddressDTO();
    addressDTO.setAddress("Prototypweg 1");
    addressDTO.setId("1");
    addressDTO.setCity("Prototuebingen");
    addressDTO.setPostcode("12345");

    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setId("1");
    customerDTO.setName("Mustermann");
    customerDTO.setFirstname("Michael");
    customerDTO.setAddress(addressDTO);
    customerDTO.addPhonesItem(phone1);
    customerDTO.addPhonesItem(phone2);
    return customerDTO;
  }

  @Override public ResponseEntity<CustomerDTO> getCustomer(@ApiParam(value = "",required=true) @PathVariable("customerId") String customerId) {
    log.info("called getCustomer " + customerId);
    return ResponseEntity.ok(getCustomer());
  }

  @Override public ResponseEntity<List<CustomerDTO>> getCustomers() {
    log.info("called getCustomers");
    return ResponseEntity.ok(Arrays.asList(getCustomer()));
  }

  @Override public ResponseEntity<Void> setCustomer(@ApiParam(value = "changed customer" ,required=true )  @Valid @RequestBody CustomerDTO customerDTO) {
    log.info("called setCustomer " + customerDTO.getId());
    return ResponseEntity.ok().build();
  }
}
