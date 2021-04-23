package de.noventi.cm.client.java;

import de.noventi.cm.client.java.example.api.MedicationsApi;
import de.noventi.cm.client.java.example.model.MedicationcontainerDTO;
import de.noventi.cm.client.java.runtime.ApiException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
      MedicationsApi medicationsApi = services.getCustomerApi(Services.BASEURL_SERVICE_LOCAL);
      log.info("Basepath of customer: " + medicationsApi.getApiClient().getBasePath());
      MedicationcontainerDTO customer = medicationsApi.getMedicationContainer("1");
      lblId.setText(customer.getId());
      lblName.setText(customer.getConsumerName());
      lblFirstname.setText(customer.getConsumerFirstname());
    } catch (de.noventi.cm.client.java.example.ApiException e) {
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
