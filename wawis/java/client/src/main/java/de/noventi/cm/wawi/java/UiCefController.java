package de.noventi.cm.wawi.java;

import java.io.File;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import lombok.extern.slf4j.Slf4j;

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

    log.info("JavaLibraryPath = " + System.getProperty("java.library.path"));

    SwingNode swingNode = new SwingNode();

    /**CefSettings cefSettings = new CefSettings();
    cefSettings.log_severity = CefSettings.LogSeverity.LOGSEVERITY_VERBOSE;
    cefSettings.resources_dir_path = "/Users/OleyMa/vcs/wawiNeu/journey/jcef_app.app/Contents/Frameworks/Chromium Embedded Framework.framework/Resources";
    cefSettings.locales_dir_path = "/Users/OleyMa/vcs/wawiNeu/journey/jcef_app.app/Contents/Frameworks/Chromium Embedded Framework.framework/Resources";
    cefSettings.ignore_certificate_errors = true;
    cefSettings.log_file = new File ("build/journey.log").getAbsolutePath();

    log.info("Create cefapp");
    CefApp cefApp = CefApp.getInstance(cefSettings);
    log.info("Create cefclient" + cefApp.getVersion().getCefVersion() + "-" + cefApp.getVersion().getChromeVersion() + "-" + cefApp.getVersion().getJcefVersion());
    
    CefClient cefClient = cefApp.createClient();
    log.info("Create cefbrowser");
    //CefBrowser cefBrowser = cefClient.createBrowser("https://localhost:8003", true, false);
    CefBrowser cefBrowser = cefClient.createBrowser("https://jenkins.intra.vsa.de", true, false);
    log.info("Render browser");
    swingNode.setContent((JComponent)cefBrowser.getUIComponent() );
    root.setCenter(swingNode);**/
  }
}
