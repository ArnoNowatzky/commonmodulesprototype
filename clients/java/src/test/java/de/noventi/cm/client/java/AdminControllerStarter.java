package de.noventi.cm.client.java;

public class AdminControllerStarter {

  public static void main(String[] args) {
    AdminController controller = new AdminController();
    controller.install();

    controller.start();

  }
}
