package de.noventi.cm.client.java;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UiController {

  @FXML
  private WebView webview;

  @FXML
  private Button btnReload;

  public void load() {
    btnReload.setOnAction(event -> reload());
  }

  private void reload () {
    log.info("Reload webview");
    webview.getEngine().load("http://localhost:8003");
  }
}
