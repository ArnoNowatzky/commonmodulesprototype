package de.noventi.cm.client.java;

import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebErrorEvent;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import lombok.extern.slf4j.Slf4j;

@Slf4j public class UiController {

  @FXML private WebView webview;

  @FXML private Button btnReload;

  public void load() {
    btnReload.setOnAction(event -> reload());
  }

  private void reload() {
    log.info("Reload webview");

    //to enable https
    File currentDir = new File("build/example/jar/keystore/commonmodule.p12");
    System.setProperty("javax.net.ssl.trustStore", currentDir.getAbsolutePath());
    System.setProperty("javax.net.ssl.trustStorePassword", "commonmodule");
    System.setProperty("javax.net.ssl.trustStoreType", "PKCS12");

    WebEngine webEngine = webview.getEngine();
    webEngine.setOnError(new EventHandler<WebErrorEvent>() {
      @Override public void handle(WebErrorEvent event) {
        log.error("Error when showing url: " + event.getMessage());
      }
    });
    webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {
      @Override public void handle(WebEvent<String> event) {
        log.error("OnAlert: " + event.getData());
      }
    });

    webEngine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
      @Override public void handle(WebEvent<String> event) {
        log.info("OnStatusChanged: " + event.getData());
      }
    });

    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
      public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
        if (webEngine.getLoadWorker().getException() != null && newState == Worker.State.FAILED) {
          log.error(webEngine.getLoadWorker().getException().toString(), webEngine.getLoadWorker().getException());
        }
      }
    });
    webview.getEngine().load("https://localhost:8003");
  }
}
