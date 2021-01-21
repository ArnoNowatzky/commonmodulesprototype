package de.noventi.cm.client.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

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

      FXMLLoader loaderAdminMask = getMaskLoader("admin");
      Parent rootAdmin = loaderAdminMask.load();
      AdminController adminController = loaderAdminMask.getController();
      adminController.load();

      FXMLLoader loaderEventMask = getMaskLoader("event");
      Parent rootEvent = loaderEventMask.load();
      EventController eventController = loaderEventMask.getController();
      eventController.load();

      Tab tab1 = new Tab("Service", rootService);
      Tab tab2 = new Tab("UI", rootUi);
      Tab tab3 = new Tab ("Admin", rootAdmin);
      Tab tab4 = new Tab ("Event", rootEvent);

      tabPane.getTabs().add(tab1);
      tabPane.getTabs().add(tab2);
      tabPane.getTabs().add(tab3);
      tabPane.getTabs().add(tab4);

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
