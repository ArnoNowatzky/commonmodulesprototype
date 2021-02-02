package de.noventi.cm.client.java;

import de.noventi.cm.client.java.runtime.ApiException;
import de.noventi.cm.client.java.service.ApiClient;
import de.noventi.cm.client.java.service.api.CustomerApi;
import de.noventi.cm.client.java.service.model.CustomerDTO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.net.ssl.KeyManager;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.control.Notifications;

@Slf4j
public class ServiceController {
  @FXML
  private Label lblId;

  @FXML
  private Label lblName;

  @FXML
  private Label lblFirstname;


  @FXML
  private Button btnReload;

  public void load () throws ApiException {
    btnReload.setOnAction(event -> reload());
  }


  private void reload() {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath("https://localhost:8002"); //TODO adapt in yaml when other clients support https

    try {

      FileInputStream fileInputStream = new FileInputStream(new File("build/example/jar/keystore/commonmodule.p12"));
      KeyStore ks= KeyStore.getInstance("PKCS12");
      ks.load(fileInputStream,"commonmodule".toCharArray());
      Certificate cerificate = ks.getCertificate("commonmodule");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cerificate.getEncoded());
      apiClient.setSslCaCert(byteArrayInputStream);
      CustomerApi customerApi = new CustomerApi(apiClient);

      log.info("Basepath of customer: " + customerApi.getApiClient().getBasePath());
      CustomerDTO customer = customerApi.getCustomer("1");
      lblId.setText(customer.getId());
      lblName.setText(customer.getName());
      lblFirstname.setText(customer.getFirstname());
    } catch (Exception e) {
      lblFirstname.setText("");
      lblName.setText("");
      lblId.setText("");
      log.error("Error fetching customer data: " + e.getLocalizedMessage(), e);
      Notifications.create().title("Synch data").text("Error synching data: " + e.getLocalizedMessage()).showError();
    }

  }
}
