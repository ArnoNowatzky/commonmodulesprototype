package de.noventi.cm.wawi.java;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationContext {

  private static String token;
  private static String mandantID = "12345";

  public static void setToken(String token) {
    ApplicationContext.token = token;
  }

  public static String login (final String mandantId, final String username, final String password) {
    String token = JWT.create().withClaim("username", username).withClaim("role", password)
        .withClaim("mandant", mandantId).withExpiresAt(new Date(System.currentTimeMillis() + 900000))
        .sign(Algorithm.HMAC512(mandantId));
    log.info("Created token " + token);
    setToken(token);
    return token;
  }

  public static void logout () {
    setToken(null);
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
