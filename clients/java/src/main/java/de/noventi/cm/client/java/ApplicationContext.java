package de.noventi.cm.client.java;

public class ApplicationContext {

  private static String token;
  private static String mandantID = "12345";

  public static void setToken(String token) {
    ApplicationContext.token = token;
  }



  public static String getToken() {
    return token;
  }

  public static String getMandantID() {
    return mandantID;
  }

  public static void setMandantID(String mandantID) {
    ApplicationContext.mandantID = mandantID;
  }

}
