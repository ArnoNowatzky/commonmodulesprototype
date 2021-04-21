package de.noventi.cm.example.db;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Customer {

  @Id
  private String id;

  private String title;

  private String name;

  private String firstname;

  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Phone> phones;
}
