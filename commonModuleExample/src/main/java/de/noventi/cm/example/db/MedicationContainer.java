package de.noventi.cm.example.db;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class MedicationContainer {

  @Id
  private String id;

  private String consumerId;

  private String consumerName;

  private String consumerFirstname;

  private Date consumerBirthday;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Medication> medications;
}
