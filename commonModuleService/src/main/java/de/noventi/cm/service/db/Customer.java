package de.noventi.cm.service.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  private String title;

  private String name;

  private String firstname;
}
