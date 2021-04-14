package de.noventi.cm.service;

import de.noventi.cm.service.db.Address;
import de.noventi.cm.service.db.Customer;
import de.noventi.cm.service.db.CustomerRepository;
import de.noventi.cm.service.db.Phone;
import de.noventi.cm.service.db.PhoneType;
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
  private CustomerRepository customerRepository;

  public void create () {
    List<Customer> customerList = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {

      Address address = new Address();
      address.setId(Integer.toString(i));
      address.setCity("London");
      address.setPostcode("W1K 7JB");
      address.setStreet("Baker Street");
      address.setHousenumber("221B");

      Customer customer = new Customer();
      customer.setId(Integer.toString(i));
      customer.setName("Holmes " + i);
      customer.setFirstname("Sherlock " + i);
      customer.setTitle("Mr.");
      customer.setAddress(address);

      List<Phone> phones = new ArrayList<>();
      Phone phone = new Phone();
      phone.setId(UUID.randomUUID().toString());
      phone.setType(PhoneType.MOBILE);
      phone.setNumber("12877125871258");
      phones.add(phone);
      Phone phone2 = new Phone();
      phone2.setId(UUID.randomUUID().toString());
      phone2.setType(PhoneType.WORK);
      phone2.setNumber("127127512875124");
      phones.add(phone2);

      customer.setPhones(phones);
      customerList.add(customer);

    }

    log.info("Creating "+ customerList.size() + " customers for test");
    customerRepository.deleteAll();
    customerRepository.saveAll(customerList);
  }
}
