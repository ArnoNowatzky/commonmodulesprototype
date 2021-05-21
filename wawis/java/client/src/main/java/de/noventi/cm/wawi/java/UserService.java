package de.noventi.cm.wawi.java;

import java.util.ArrayList;
import java.util.List;

public class UserService {
  private static List<User> userList = new ArrayList<>();

  static {
    userList.add(new User("apotheker", "apotheker"));
    userList.add(new User("pda", "pda"));
    userList.add(new User("admin", "admin"));
  }
}
