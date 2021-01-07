package de.noventi.cm.client.java;

public class ServiceControllerStarter {

  public static void main(String[] args) {
    ServiceController controller = new ServiceController();
    controller.install();

    controller.start();

  }
}
