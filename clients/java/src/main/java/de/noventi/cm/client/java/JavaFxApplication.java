package de.noventi.cm.client.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaFxApplication extends Application {




  public static void main(String[] args) {
    launch(JavaFxApplication.class, args);
  }

  @Override public void start(Stage primaryStage) throws Exception {

    try {

      TabPane tabPane = new TabPane();

      FXMLLoader loaderServiceMask = getMaskLoader("service");
      Parent rootService = loaderServiceMask.load();
      ServiceController serviceController = loaderServiceMask.getController();
      serviceController.load();

      FXMLLoader loaderUiMask = getMaskLoader("ui");
      Parent rootUi = loaderUiMask.load();
      UiController uiController = loaderUiMask.getController();
      uiController.load();

      FXMLLoader loaderUiCefMask = getMaskLoader("uicef");
      Parent rootUiCef = loaderUiCefMask.load();
      UiCefController uiCefController = loaderUiCefMask.getController();
      uiCefController.load();

      FXMLLoader loaderAdminMask = getMaskLoader("admin");
      Parent rootAdmin = loaderAdminMask.load();
      AdminController adminController = loaderAdminMask.getController();
      adminController.load();

      FXMLLoader loaderEventMask = getMaskLoader("event");
      Parent rootEvent = loaderEventMask.load();
      EventController eventController = loaderEventMask.getController();
      eventController.load();

      FXMLLoader loaderLoginMask = getMaskLoader("login");
      Parent rootLogin = loaderLoginMask.load();
      LoginController loginController = loaderLoginMask.getController();
      loginController.load();

      Tab tabLogin = new Tab("Login",rootLogin);
      Tab tabAdmin = new Tab ("Admin", rootAdmin);

      Tab tabService = new Tab("Service", rootService);
      Tab tabUi = new Tab("UI", rootUi);
      Tab tabUiCef = new Tab("UI CEF", rootUiCef);
      Tab tabEvent = new Tab ("Event", rootEvent);

      tabPane.getTabs().addAll(tabLogin, tabAdmin, tabService, tabUi, tabUiCef, tabEvent);

      VBox vBox = new VBox(tabPane);
      Scene scene = new Scene(vBox);

      primaryStage.setScene(scene);
      primaryStage.setTitle("Common Modules Java Client");

      primaryStage.setWidth(1100);
      primaryStage.setHeight(700);
      primaryStage.show();
    } catch (Exception e) {
      log.error("Error in setup " + e.getLocalizedMessage(), e);
    }

  }



  private FXMLLoader getMaskLoader(String name) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + name + ".fxml"));
    loader.setClassLoader(getClass().getClassLoader());
    return loader;
  }
}
