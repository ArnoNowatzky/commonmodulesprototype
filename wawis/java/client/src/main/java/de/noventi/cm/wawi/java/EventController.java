package de.noventi.cm.wawi.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventController {
  @FXML
  private ListView<String> lviMessages;

  private ObservableList<String> messages = FXCollections.observableArrayList();


  public void initialize () {
    lviMessages.setItems(messages);

  }

  public void load() {
    log.info ("Load called");
    Thread thread = new Thread(new GetCurrentTimeConsumer(messages));
    thread.start();
  }
}
