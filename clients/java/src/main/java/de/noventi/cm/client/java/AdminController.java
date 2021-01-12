package de.noventi.cm.client.java;

import de.noventi.cm.client.java.runtime.ApiException;
import de.noventi.cm.client.java.runtime.api.ModuleApi;
import de.noventi.cm.client.java.runtime.model.SetupModulesParamDTO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

@Slf4j
public class AdminController {

  @FXML
  private ComboBox<String> cboRuntimeType;

  @FXML
  private Button btnInstall;

  @FXML
  private Button btnStart;


  File examplePath = new File ("build/example");

  public void load () throws ApiException {

    cboRuntimeType.setItems(FXCollections.observableArrayList(Arrays.asList("jar", "docker")));
    cboRuntimeType.getSelectionModel().select("jar");
    
    btnInstall.setOnAction(event -> install());
    btnStart.setOnAction(event -> start());

  }

  private String getInstallDescription () {
    return "/install_" + cboRuntimeType.getSelectionModel().getSelectedItem() + ".xml";
  }

  public void install () {
    ModuleApi moduleApi = new ModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());
    InputStream inputStream = getClass().getResourceAsStream(getInstallDescription());
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
    InputStream inputStream = getClass().getResourceAsStream(getInstallDescription());
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


}
