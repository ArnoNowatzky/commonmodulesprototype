package de.noventi.cm.service.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

  @Id
  private String id;

  private String street;

  private String housenumber;

  private String city;

  private String postcode;
}
