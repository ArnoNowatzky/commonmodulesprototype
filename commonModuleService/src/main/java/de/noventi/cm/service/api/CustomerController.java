package de.noventi.cm.service.api;

import de.noventi.cm.service.db.Customer;
import de.noventi.cm.service.db.CustomerRepository;
import de.noventi.cm.service.model.CustomerDTO;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController implements CustomersApi{

  @Value("${spring.datasource.url}")
  private String datasourceUrl;

  @Autowired
  private CustomerRepository customerRepository;

  private CustomerMapper customerMapper = new CustomerMapper();

  public CustomerController () {
    log.info("Create CustomerController");
  }

  @Override public ResponseEntity<CustomerDTO> getCustomer(@ApiParam(value = "",required=true) @PathVariable("customerId") String customerId) {
    long currentTime = System.currentTimeMillis();
    log.info("called getCustomer " + customerId);

    if (customerId.startsWith("W")) {
      log.info("without database");
      String realId = customerId.substring(1);
      CustomerDTO customerDTO = new CustomerDTO();
      customerDTO.setFirstname("Sherlock " + realId.trim());
      return ResponseEntity.ok(customerDTO);
    }
    Optional<Customer> byId = customerRepository.findById(customerId);
    if (byId.isPresent()) {
      long duration = System.currentTimeMillis() - currentTime;
      log.info("Found customer " + byId.get().getId() + "(" + duration + " ms)");
      return ResponseEntity.ok(customerMapper.toCustomerDTO(byId.get()));
    }
    else {
      log.error("No customer found for id " + customerId);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @Override public ResponseEntity<List<CustomerDTO>> getCustomers() {
    log.info("called getCustomers");
    log.info("- url: " + datasourceUrl);

    Iterable<Customer> iterable = customerRepository.findAll();
    List<CustomerDTO> result = new ArrayList<CustomerDTO>();
    for (Customer next: iterable) {
      result.add(customerMapper.toCustomerDTO(next));
    }
    return ResponseEntity.ok(result);
  }

  @Override public ResponseEntity<Void> setCustomer(@ApiParam(value = "",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "changed customer" ,required=true )  @Valid @RequestBody CustomerDTO customerDTO) {
    log.info("called setCustomer " + customerDTO.getId());
    if (true)
      throw new IllegalStateException("TODO");
    return ResponseEntity.ok().build();
  }
}
