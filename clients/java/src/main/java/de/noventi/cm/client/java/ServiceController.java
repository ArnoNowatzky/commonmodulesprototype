package de.noventi.cm.client.java;

import de.noventi.cm.client.java.runtime.ApiException;
import de.noventi.cm.client.java.runtime.api.ModuleApi;
import de.noventi.cm.client.java.runtime.model.SetupModulesParamDTO;
import de.noventi.cm.client.java.service.api.CustomerApi;
import de.noventi.cm.client.java.service.model.CustomerDTO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

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

  File examplePath = new File ("build/example");

  public void load () throws ApiException {

    reload();

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
      log.error("Error fetching customer data: " + e.getLocalizedMessage(), e, customerApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e);
    }

  }
}
