package de.noventi.cm.client.java;

import de.noventi.cm.client.java.runtime.ApiException;
import de.noventi.cm.client.java.service.api.CustomerApi;
import de.noventi.cm.client.java.service.model.CustomerDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    CustomerApi customerApi = new CustomerApi();

    try {
      log.info("Basepath of customer: " + customerApi.getApiClient().getBasePath());
      CustomerDTO customer = customerApi.getCustomer("1");
      lblId.setText(customer.getId());
      lblName.setText(customer.getName());
      lblFirstname.setText(customer.getFirstname());
    } catch (Exception e) {
      lblFirstname.setText("");
      lblName.setText("");
      lblId.setText("");
      log.error("Error fetching customer data: " + e.getLocalizedMessage(), e, customerApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e);
      Notifications.create().title("Synch data").text("Error synching data: " + e.getLocalizedMessage()).showError();
    }

  }
}
