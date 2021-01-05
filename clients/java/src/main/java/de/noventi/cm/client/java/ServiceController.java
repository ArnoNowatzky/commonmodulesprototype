package de.noventi.cm.client.java;

import de.noventi.cm.client.java.api.CustomerApi;
import de.noventi.cm.client.java.api.ModuleApi;
import de.noventi.cm.client.java.model.CustomerDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

@Slf4j
public class ServiceController {
  @FXML
  public Label lblId;

  @FXML
  public Label lblName;

  @FXML
  public Label lblFirstname;

  @FXML
  public Button btnInstall;

  @FXML
  public Button btnFetchData;

  public void load () throws ApiException {

    fetchData();

    btnFetchData.setOnAction(event -> fetchData());

    btnInstall.setOnAction(new EventHandler<>() {
      @Override public void handle(ActionEvent event) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8001");
        ModuleApi moduleApi = new ModuleApi(apiClient);
        InputStream inputStream = getClass().getResourceAsStream("/install.xml");
        StringWriter stringWriter = new StringWriter();
        try {
          IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

          log.info("Send modules descriptor " + stringWriter.toString());

          moduleApi.setupModules(stringWriter.toString());
        } catch (IOException e) {
          log.error(e.getLocalizedMessage(), e);;

        } catch (ApiException e) {
          log.error("Error installing new modules " + e.getResponseBody());
          throw new IllegalStateException(e);
        }

      }
    });

  }

  private void fetchData () {
    try {
      ApiClient apiClient = new ApiClient();
      apiClient.setBasePath("http://localhost:8002");
      CustomerApi customerApi = new CustomerApi(apiClient);
      CustomerDTO customer = customerApi.getCustomer("1");
      lblId.setText(customer.getId());
      lblName.setText(customer.getName());
      lblFirstname.setText(customer.getFirstname());
    } catch (Exception e) {
      log.error("Error fetching customer data: " + e.getLocalizedMessage(), e);

    }

  }
}
