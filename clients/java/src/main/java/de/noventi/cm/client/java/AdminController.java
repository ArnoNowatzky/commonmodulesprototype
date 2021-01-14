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

  private String getInstallFile() {
    String type = cboRuntimeType == null ? "jar" : cboRuntimeType.getSelectionModel().getSelectedItem();
    return "/install_" + type + ".xml";
  }

  private String getInstallDescription () throws IOException {
    InputStream inputStream = getClass().getResourceAsStream(getInstallFile());
    StringWriter stringWriter = new StringWriter();
    IOUtils.copy(inputStream, stringWriter, Charset.defaultCharset());

    String descriptor = stringWriter.toString();
    descriptor = descriptor.replace("~", System.getProperty("user.home"));
    return descriptor;
  }

  public void install () {
    ModuleApi moduleApi = new ModuleApi();
    moduleApi.getApiClient().setReadTimeout(60000);
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());
    try {
      String description = getInstallDescription();

      log.info("Send modules descriptor " + description);

      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(description).path(examplePath.getAbsolutePath());
      moduleApi.installModules(setupModulesParamDTO);
      log.info("Calling install finished");
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);;

    } catch (ApiException e) {
      log.error("Error installing new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e.getCause());
      throw new IllegalStateException(e.getLocalizedMessage(), e);
    }


  }

  public void start () {
    ModuleApi moduleApi = new ModuleApi();
    moduleApi.getApiClient().setReadTimeout(60000);
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());
    InputStream inputStream = getClass().getResourceAsStream(getInstallFile());
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
