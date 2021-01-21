package de.noventi.cm.runtime.module.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CurrentTimeProducer {

  @Autowired
  JmsTemplate jmsTemplate;

  @Value("currentTime")
  private String topic;

  public void sendMessage (final String message) {
    log.info("Send message to topic " + topic + ":" + message);
    try {
      jmsTemplate.convertAndSend(topic, message);
    } catch (Exception e) {
      log.error("Recieved exception during sending message: " + e.getLocalizedMessage(), e);
    }
  }
}
