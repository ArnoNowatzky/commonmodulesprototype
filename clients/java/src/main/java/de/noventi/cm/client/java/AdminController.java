package de.noventi.cm.client.java;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import de.noventi.cm.client.java.runtime.ApiClient;
import de.noventi.cm.client.java.runtime.ApiException;
import de.noventi.cm.client.java.runtime.api.ModuleApi;
import de.noventi.cm.client.java.runtime.model.SetupModulesParamDTO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;

@Slf4j public class AdminController {

  private String SECRET = "Common Modules are cool";

  @FXML private  TextField txtUsername;
  @FXML private  TextField txtPassword;
  @FXML private  Button btnLogin;
  @FXML private  Button btnLogout;

  @FXML private ComboBox<String>cboAuthenticationType;

  @FXML private ComboBox<String> cboRuntimeType;

  @FXML private Button btnInstall;

  @FXML private Button btnStart;

  @FXML private Button btnStop;

  private File getExamplePath() {
    return new File("build/example/" + cboRuntimeType.getSelectionModel().getSelectedItem());
  }

  public void load() {

    cboAuthenticationType.setItems(FXCollections.observableArrayList(Arrays.asList("own", "oauth2")));
    cboAuthenticationType.getSelectionModel().select("own");


    cboRuntimeType.setItems(FXCollections.observableArrayList(Arrays.asList("jar", "docker")));
    cboRuntimeType.getSelectionModel().select("jar");

    btnInstall.setOnAction(event -> install());
    btnStart.setOnAction(event -> start());
    btnStop.setOnAction(event -> stop());
    btnLogin.setOnAction(event -> login());
    btnLogout.setOnAction(event -> logout());

  }



  private String getInstallDescription() throws IOException {
    String type = cboRuntimeType == null ? "jar" : cboRuntimeType.getSelectionModel().getSelectedItem();
    String file = "../install_" + type + ".xml";
    File installFile = new File(file).getAbsoluteFile();
    log.info("Using installfile " + installFile.getAbsolutePath());

    String descriptor = FileUtils.readFileToString(installFile, Charset.defaultCharset());
    descriptor = descriptor.replace("~", System.getProperty("user.home"));
    return descriptor;
  }

  private ModuleApi createModuleApi() {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath("https://localhost:8001"); //TODO adapt in yaml when other clients support https
    try {
      FileInputStream fileInputStream = new FileInputStream(new File("build/example/jar/keystore/commonmodule.p12"));
      KeyStore ks = KeyStore.getInstance("PKCS12");
      ks.load(fileInputStream, "commonmodule".toCharArray());
      Certificate cerificate = ks.getCertificate("commonmodule");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cerificate.getEncoded());
      apiClient.setSslCaCert(byteArrayInputStream);
    } catch (Exception e) {
      throw new IllegalStateException("Error creating module api: " + e.getLocalizedMessage(), e);
    }
    apiClient.setReadTimeout(60000);
    ModuleApi moduleApi = new ModuleApi(apiClient);
    return moduleApi;

  }

  public void install() {

    ModuleApi moduleApi = createModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String description = getInstallDescription();

      log.info("Send modules descriptor " + description);

      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(description)
          .path(getExamplePath().getAbsolutePath());
      moduleApi.installModules(setupModulesParamDTO);
      log.info("Calling install finished");
    } catch (ApiException e) {
      log.error(
          "Error installing new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e.getCause());
      Notifications.create().title("Installing modules").text("Error installing modules: " + e.getLocalizedMessage())
          .showError();
    } catch (Exception e) {
      log.error(e.getLocalizedMessage(), e);
    }

  }

  public void start() {
    ModuleApi moduleApi = createModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String installDescription = getInstallDescription();
      log.info("Send modules descriptor " + installDescription);
      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(installDescription)
          .path(getExamplePath().getAbsolutePath());
      moduleApi.startModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);

    } catch (ApiException e) {
      log.error(
          "Error starting new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e);
      Notifications.create().title("Start modules").text("Error starting modules: " + e.getLocalizedMessage())
          .showError();
    }

  }

  public void logout() {
    ApplicationContext.setToken(null);
  }

  public void login () {
    String authentication = cboAuthenticationType.getSelectionModel().getSelectedItem();
    log.info("Login of authentication type " + authentication);
    if (authentication.equalsIgnoreCase("own")) {
      //create jwt myself, can be validated via https://jwt.io/
      String token = JWT.create().withClaim("username", txtUsername.getText()).withClaim("role", txtUsername.getText())
        .withClaim("mandant", ApplicationContext.getMandantID()).withExpiresAt(new Date(System.currentTimeMillis() + 900000))
        .sign(Algorithm.HMAC512(ApplicationContext.getMandantID()));
      log.info("Created token " + token);
      ApplicationContext.setToken(token);
      try {
        DecodedJWT jwt = JWT.decode(token);
        System.out.println ("Header     : " + jwt.getHeader());
        System.out.println ("Signature  : " + jwt.getSignature());
        System.out.println ("Payload    : " + jwt.getPayload());
        System.out.println ("Type       : " + jwt.getType());
        System.out.println ("Expiration : " + jwt.getExpiresAt());
        System.out.println ("Algorithm  : " + jwt.getAlgorithm());
        System.out.println ("Mandant    : " + ApplicationContext.getMandantID());
        for (String next: jwt.getClaims().keySet()) {
          System.out.println ("Claim      : " + next);
          Claim claim = jwt.getClaim(next);
          System.out.println("Value       : " + claim.asString());
        }

        Algorithm algorithm = Algorithm.HMAC512(ApplicationContext.getMandantID());
        algorithm.verify(jwt);
        System.out.println ("Verify secret OK");

        //Fails:
        //algorithm = Algorithm.HMAC512("Hallo");
        //algorithm.verify(jwt);
        //System.out.println ("Verify Hallo OK");



      } catch (JWTDecodeException exception){
        log.error(exception.getLocalizedMessage());
        //Invalid token
      }



    }
    else {
      //oauth2

    }
  }

  public void stop() {
    ModuleApi moduleApi = createModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String installDescription = getInstallDescription();
      log.info("Send modules descriptor " + installDescription);
      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(installDescription)
          .path(getExamplePath().getAbsolutePath());
      moduleApi.stopModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);
    } catch (ApiException e) {
      log.error(
          "Error stopping new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e);
      Notifications.create().title("Stop modules").text("Error stopping modules: " + e.getLocalizedMessage())
          .showError();
    }
  }

}
