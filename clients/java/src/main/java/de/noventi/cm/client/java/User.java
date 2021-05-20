package de.noventi.cm.client.java;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

  private String username;

  private String password;
}
