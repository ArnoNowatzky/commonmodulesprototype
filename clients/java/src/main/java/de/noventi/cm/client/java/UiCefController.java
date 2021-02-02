package de.noventi.cm.client.java;

import com.jogamp.opengl.awt.GLJPanel;
import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebErrorEvent;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import lombok.extern.slf4j.Slf4j;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.browser.CefBrowser;

@Slf4j public class UiCefController {

  @FXML private BorderPane root;
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

    SwingNode swingNode = new SwingNode();

    CefApp cefApp = CefApp.getInstance();
    CefClient cefClient = cefApp.createClient();
    CefBrowser cefBrowser = cefClient.createBrowser("https://localhost:8003", true, false);
    swingNode.setContent( (GLJPanel) cefBrowser.getUIComponent() );
    root.setCenter(swingNode);
  }
}
