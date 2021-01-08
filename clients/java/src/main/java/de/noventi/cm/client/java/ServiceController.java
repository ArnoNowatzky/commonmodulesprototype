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
  private Label lblId;

  @FXML
  private Label lblName;

  @FXML
  private Label lblFirstname;

  @FXML
  private Button btnInstall;

  @FXML
  private Button btnStart;

  @FXML
  private Button btnFetchData;

  File examplePath = new File ("build/example");

  public void load () throws ApiException {

    fetchData();

    btnFetchData.setOnAction(event -> fetchData());
    btnInstall.setOnAction(event -> install());
    btnStart.setOnAction(event -> start());

  }

  public void install () {
    ModuleApi moduleApi = new ModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());
    InputStream inputStream = getClass().getResourceAsStream("/install.xml");
    StringWriter stringWriter = new StringWriter();
    try {
      IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

      log.info("Send modules descriptor " + stringWriter.toString());

      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(stringWriter.toString()).path(examplePath.getAbsolutePath());
      moduleApi.installModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);;

    } catch (ApiException e) {
      log.error("Error installing new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e);
    }


  }

  public void start () {
    ModuleApi moduleApi = new ModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());
    InputStream inputStream = getClass().getResourceAsStream("/install.xml");
    StringWriter stringWriter = new StringWriter();
    try {
      IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

      log.info("Send modules descriptor " + stringWriter.toString());

      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(stringWriter.toString()).path(examplePath.getAbsolutePath());
      moduleApi.startModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);

    } catch (ApiException e) {
      log.error("Error starting new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e);
    }

  }

  private void fetchData () {
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
