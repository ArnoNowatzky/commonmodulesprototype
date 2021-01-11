package de.noventi.cm.client.java;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class UiController {

  @FXML
  private WebView webview;

  public void load() {
    webview.getEngine().load("http://localhost:8003");
  }
}
