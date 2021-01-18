package de.noventi.cm.client.java;

import de.noventi.cm.client.java.runtime.ApiException;
import de.noventi.cm.client.java.runtime.api.ModuleApi;
import de.noventi.cm.client.java.runtime.model.SetupModulesParamDTO;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;

@Slf4j
public class AdminController {


  @FXML
  private ComboBox<String> cboRuntimeType;

  @FXML
  private Button btnInstall;

  @FXML
  private Button btnStart;

  @FXML
  private Button btnStop;

  File examplePath = new File ("build/example");

  public void load () {

    cboRuntimeType.setItems(FXCollections.observableArrayList(Arrays.asList("jar", "docker")));
    cboRuntimeType.getSelectionModel().select("jar");
    
    btnInstall.setOnAction(event -> install());
    btnStart.setOnAction(event -> start());
    btnStop.setOnAction(event -> stop());

  }

  private String getInstallDescription () throws IOException {
    String type = cboRuntimeType == null ? "jar" : cboRuntimeType.getSelectionModel().getSelectedItem();
    String file = "../install_" + type + ".xml";
    File installFile = new File (file).getAbsoluteFile();
    log.info("Using installfile " + installFile.getAbsolutePath());

    String descriptor = FileUtils.readFileToString(installFile, Charset.defaultCharset());
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
      log.error(e.getLocalizedMessage(), e);

    } catch (ApiException e) {
      log.error("Error installing new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e.getCause());
      Notifications.create().title("Installing modules").text("Error installing modules: " + e.getLocalizedMessage()).showError();
    }


  }

  public void start () {
    ModuleApi moduleApi = new ModuleApi();
    moduleApi.getApiClient().setReadTimeout(60000);
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String installDescription = getInstallDescription();
      log.info("Send modules descriptor " + installDescription);
      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(installDescription).path(examplePath.getAbsolutePath());
      moduleApi.startModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);

    } catch (ApiException e) {
      log.error("Error starting new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e);
      Notifications.create().title("Start modules").text("Error starting modules: " + e.getLocalizedMessage()).showError();
    }

  }

  public void stop() {
    ModuleApi moduleApi = new ModuleApi();
    moduleApi.getApiClient().setReadTimeout(60000);
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String installDescription = getInstallDescription();
      log.info("Send modules descriptor " + installDescription);
      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(installDescription).path(examplePath.getAbsolutePath());
      moduleApi.stopModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);
    } catch (ApiException e) {
      log.error("Error stopping new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e.getLocalizedMessage(), e);
      Notifications.create().title("Stop modules").text("Error stopping modules: " + e.getLocalizedMessage()).showError();
    }
  }


}
