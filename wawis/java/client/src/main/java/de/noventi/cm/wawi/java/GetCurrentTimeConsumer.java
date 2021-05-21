package de.noventi.cm.wawi.java;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

@Slf4j public class GetCurrentTimeConsumer implements Runnable, ExceptionListener {

  private ObservableList<String> messages = null;

  public GetCurrentTimeConsumer(ObservableList<String> messages) {
    this.messages = messages;
  }

  @Override public void run() {
    log.info("Run " + getClass().getName());
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
    Connection connection = null;
    try {
      connection = connectionFactory.createConnection();
      connection.start();

      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Topic currentTime = session.createTopic("currentTime");
      MessageConsumer consumer = session.createConsumer(currentTime);
      consumer.setMessageListener(new MessageListener() {
        @Override public void onMessage(Message message) {
          TextMessage textMessage = ((TextMessage) message);
          Platform.runLater(new Runnable() {
            @Override public void run() {
              try {
                log.debug("Message recieved: " + textMessage.getText());
                messages.add(textMessage.getText());
              } catch (JMSException e) {
                log.error(e.getLocalizedMessage(), e);
              }
            }
          });

        }
      });
    } catch (JMSException e) {
      log.error(e.getLocalizedMessage(), e);
    }

  }

  @Override public synchronized void onException(JMSException exception) {
    log.error(exception.getLocalizedMessage(), exception);
  }
}
