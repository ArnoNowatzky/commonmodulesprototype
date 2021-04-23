package de.noventi.cm.example.db;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Medication {

  @Id
  private String id;

  private String pharmacode;

  private String name;

}
