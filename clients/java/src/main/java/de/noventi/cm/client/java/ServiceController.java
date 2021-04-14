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

  private Services services = new Services();

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

    try {
      CustomerApi customerApi = services.getCustomerApi(Services.BASEURL_SERVICE_LOCAL);
      log.info("Basepath of customer: " + customerApi.getApiClient().getBasePath());
      CustomerDTO customer = customerApi.getCustomer("1");
      lblId.setText(customer.getId());
      lblName.setText(customer.getName());
      lblFirstname.setText(customer.getFirstname());
    } catch (de.noventi.cm.client.java.service.ApiException e) {
      lblFirstname.setText("");
      lblName.setText("");
      lblId.setText("");
      String completeError = e.getLocalizedMessage() + "-" + e.getResponseBody();
      log.error("Error fetching customer data: " + completeError, e);
      Notifications.create().title("Synch data").text("Error synching data: " + completeError).showError();
    } catch (Exception e) {
      lblFirstname.setText("");
      lblName.setText("");
      lblId.setText("");
      log.error("Error fetching customer data: " + e.getLocalizedMessage() , e);
      Notifications.create().title("Synch data").text("Error synching data: " + e.getLocalizedMessage()).showError();
    }

  }
}
