package de.noventi.cm.client.java;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Arrays;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;

@Slf4j public class LoginController {

  private String SECRET = "Common Modules are cool";

  @FXML private  TextField txtUsername;
  @FXML private  TextField txtPassword;
  @FXML private  Button btnLogin;
  @FXML private  Button btnLogout;

  @FXML private ComboBox<String>cboAuthenticationType;

  @FXML private Label lblLoggedInData;

  public void load() {

    cboAuthenticationType.setItems(FXCollections.observableArrayList(Arrays.asList("own", "oauth2")));
    cboAuthenticationType.getSelectionModel().select("own");

    btnLogin.setOnAction(event -> login());
    btnLogout.setOnAction(event -> logout());
    lblLoggedInData.setText(getLoginData());

  }

  public String getLoginData () {
    String loginData = "";
    String token = ApplicationContext.getToken();
    if (token != null) {
      DecodedJWT jwt = JWT.decode(token);
      loginData += "Header     : " + jwt.getHeader() + "\n";
      loginData += "Signature  : " + jwt.getSignature() + "\n";
      loginData += "Payload    : " + jwt.getPayload() + "\n";
      loginData += "Type       : " + jwt.getType() + "\n";
      loginData += "Expiration : " + jwt.getExpiresAt() + "\n";
      loginData += "Algorithm  : " + jwt.getAlgorithm() + "\n";
      loginData += "Mandant    : " + ApplicationContext.getMandantID() + "\n";
      for (String next : jwt.getClaims().keySet()) {
        Claim claim = jwt.getClaim(next);
        loginData += "Claim      : " + next + " -> " + claim.asString() + "\n";
      }
    }
    else
      loginData += "No token available";

    return loginData;
  }

  public void logout() {
    ApplicationContext.logout();
    lblLoggedInData.setText(getLoginData());
  }

  public void login () {
    String authentication = cboAuthenticationType.getSelectionModel().getSelectedItem();
    log.info("Login of authentication type " + authentication);
    if (authentication.equalsIgnoreCase("own")) {
      //create jwt myself, can be validated via https://jwt.io/
      String token = ApplicationContext.login(ApplicationContext.getMandantID(), txtUsername.getText(), txtUsername.getText());
      try {
        DecodedJWT jwt = JWT.decode(token);
        Algorithm algorithm = Algorithm.HMAC512(ApplicationContext.getMandantID());
        algorithm.verify(jwt);

        //Fails:
        //algorithm = Algorithm.HMAC512("Hallo");
        //algorithm.verify(jwt);
        //System.out.println ("Verify Hallo OK");

      } catch (JWTDecodeException exception){
        log.error(exception.getLocalizedMessage());
        //Invalid token
      } finally {
        lblLoggedInData.setText(getLoginData());
      }



    }
    else {
      //oauth2

    }
  }



}
