package de.noventi.cm.wawi.java;

import de.noventi.cm.wawi.java.nci.ApiClient;
import de.noventi.cm.wawi.java.nci.ApiException;
import de.noventi.cm.wawi.java.nci.api.ModuleApi;
import de.noventi.cm.wawi.java.nci.model.SetupModulesParamDTO;
import de.noventi.cm.wawi.java.nci.model.StatusModuleReturnDTO;
import de.noventi.cm.wawi.java.nci.model.StatusModulesReturnDTO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;

@Slf4j public class AdminController {

  @FXML private ComboBox<String> cboRuntimeType;

  @FXML private Button btnInstall;

  @FXML private Button btnStart;

  @FXML private Button btnStop;

  @FXML private Button btnStatus;

  @FXML
  private TableView<StatusModuleReturnDTO> tabModules;

  private ObservableList<StatusModuleReturnDTO> modules = FXCollections.observableArrayList();

  private File getExamplePath() {
    return new File("build/example/" + cboRuntimeType.getSelectionModel().getSelectedItem());
  }

  public void load() {

    cboRuntimeType.setItems(FXCollections.observableArrayList(Arrays.asList("jar", "docker")));
    cboRuntimeType.getSelectionModel().select("jar");

    TableColumn<StatusModuleReturnDTO, String> moduleColumn = new TableColumn<>("module");
    moduleColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    TableColumn<StatusModuleReturnDTO, String> runningColumn = new TableColumn<>("running");
    runningColumn.setCellValueFactory(new PropertyValueFactory<>("running"));
    TableColumn<StatusModuleReturnDTO, String> instanceIdColumn = new TableColumn<>("instance ID");
    instanceIdColumn.setCellValueFactory(new PropertyValueFactory<>("instanceId"));

    TableColumn<StatusModuleReturnDTO, Void> startStopColumn = new TableColumn<>("start/Stop");
    startStopColumn.setCellFactory(new Callback<>() {
      @Override public TableCell<StatusModuleReturnDTO, Void> call(TableColumn<StatusModuleReturnDTO, Void> param) {
        final TableCell<StatusModuleReturnDTO, Void> cell = new TableCell<>() {
          private final Button btn = new Button();
          {
            btn.setOnAction((ActionEvent event) -> {
              StatusModuleReturnDTO data = getTableView() != null ? getTableView().getItems().get(getIndex()) : null;
              String action = btn.getText();
              System.out.println (action + " on " + data.getId());
              if (data.getRunning() != null && data.getRunning().equals(Boolean.TRUE)) {
                stopAllModules(Arrays.asList(data.getId()));
              }
              else {
                startAllModules(Arrays.asList(data.getId()));
              }

            });
          }

          @Override public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              StatusModuleReturnDTO data = getTableView() != null ? getTableView().getItems().get(getIndex()) : null;

              btn.setText(data.getRunning() != null && data.getRunning().equals(Boolean.TRUE) ? "Stop" : "Start");
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    });

    tabModules.getColumns().addAll(moduleColumn, runningColumn, instanceIdColumn, startStopColumn);
    tabModules.setPlaceholder(new Label("No data loaded. Press button 'Get status' to get data"));
    tabModules.setItems(modules);



    btnInstall.setOnAction(event -> installAllModules());
    btnStart.setOnAction(event -> startAllModules(null));
    btnStop.setOnAction(event -> stopAllModules(null));
    btnStatus.setOnAction(event -> getStatus());
  }


  private String getInstallDescription() throws IOException {
    String type = (cboRuntimeType == null ||cboRuntimeType.getSelectionModel().getSelectedItem() == null) ? "jar" : cboRuntimeType.getSelectionModel().getSelectedItem();
    String file = "../install_" + type + ".xml";
    File installFile = new File(file).getAbsoluteFile();
    log.info("Using installfile " + installFile.getAbsolutePath());

    String descriptor = FileUtils.readFileToString(installFile, Charset.defaultCharset());
    descriptor = descriptor.replace("~", System.getProperty("user.home"));
    return descriptor;
  }

  private ModuleApi createModuleApi() {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath("https://localhost:8001"); //TODO adapt in yaml when other clients support https
    try {
      FileInputStream fileInputStream = new FileInputStream(new File("build/example/jar/keystore/commonmodule.p12"));
      KeyStore ks = KeyStore.getInstance("PKCS12");
      ks.load(fileInputStream, "commonmodule".toCharArray());
      Certificate cerificate = ks.getCertificate("commonmodule");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cerificate.getEncoded());
      apiClient.setSslCaCert(byteArrayInputStream);
    } catch (Exception e) {
      throw new IllegalStateException("Error creating module api: " + e.getLocalizedMessage(), e);
    }
    apiClient.setReadTimeout(60000);
    ModuleApi moduleApi = new ModuleApi(apiClient);
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());
    return moduleApi;

  }

  public void getStatus() {
    ModuleApi moduleApi = createModuleApi();
    try {
      String description = getInstallDescription();

      log.info("Send modules descriptor " + description);

      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(description)
          .path(getExamplePath().getAbsolutePath());
      StatusModulesReturnDTO statusModulesReturnDTO = moduleApi.statusModules(setupModulesParamDTO);
      this.modules.setAll(statusModulesReturnDTO.getModules());
      log.info("Calling get status finished (" + this.modules.size() + ")");
    } catch (ApiException e) {
      log.error(
          "Error getting status of modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e.getCause());
      Notifications.create().title("Status modules").text("Error getting status of modules: " + e.getLocalizedMessage()).showError();
    } catch (Exception e) {
      log.error(e.getLocalizedMessage(), e);
    }

  }


  public void installAllModules() {

    ModuleApi moduleApi = createModuleApi();

    try {
      String description = getInstallDescription();

      log.info("Send modules descriptor " + description);

      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(description)
          .path(getExamplePath().getAbsolutePath());
      moduleApi.installModules(setupModulesParamDTO);
      log.info("Calling install finished");
    } catch (ApiException e) {
      log.error(
          "Error installing new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e.getCause());
      Notifications.create().title("Installing modules").text("Error installing modules: " + e.getLocalizedMessage())
          .showError();
    } catch (Exception e) {
      log.error(e.getLocalizedMessage(), e);
    }

  }

  public void startAllModules(final List<String> moduleIds) {
    ModuleApi moduleApi = createModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String installDescription = getInstallDescription();
      log.info("Send modules descriptor " + installDescription);
      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(installDescription)
          .path(getExamplePath().getAbsolutePath()).affectedModules(moduleIds);
      moduleApi.startModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);

    } catch (ApiException e) {
      log.error(
          "Error starting new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e);
      Notifications.create().title("Start modules").text("Error starting modules: " + e.getLocalizedMessage())
          .showError();
    }

  }


  public void stopAllModules(final List<String> modulesIds) {
    ModuleApi moduleApi = createModuleApi();
    log.info("Basepath of runtime: " + moduleApi.getApiClient().getBasePath());

    try {
      String installDescription = getInstallDescription();
      log.info("Send modules descriptor " + installDescription);
      SetupModulesParamDTO setupModulesParamDTO = new SetupModulesParamDTO().descriptor(installDescription)
          .path(getExamplePath().getAbsolutePath()).affectedModules(modulesIds);
      moduleApi.stopModules(setupModulesParamDTO);
    } catch (IOException e) {
      log.error(e.getLocalizedMessage(), e);
    } catch (ApiException e) {
      log.error(
          "Error stopping new modules " + e.getResponseBody() + "-" + moduleApi.getApiClient().getBasePath() + ":" + e
              .getLocalizedMessage(), e);
      Notifications.create().title("Stop modules").text("Error stopping modules: " + e.getLocalizedMessage())
          .showError();
    }
  }

}
