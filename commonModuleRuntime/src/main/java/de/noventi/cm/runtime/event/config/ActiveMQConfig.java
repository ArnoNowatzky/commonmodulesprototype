package de.noventi.cm.runtime.event.config;

import javax.jms.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@Slf4j
public class ActiveMQConfig {

  @Value("${active-mq.broker-url}")
  private String brokerUrl;

/**  @Bean embedded broker
  public BrokerService broker() throws Exception {
    //TODO for docker runtime the broker must run in docker (docker-compose)
    log.info("Configure broker with broker url " + brokerUrl);
    BrokerService broker = new BrokerService();
    broker.addConnector(brokerUrl);
    return broker;
  }**/

  @Bean
  public ConnectionFactory connectionFactory (){
    log.info("Set brokerUrl for activeMQ: " + brokerUrl);
    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setBrokerURL(brokerUrl);
    return activeMQConnectionFactory;
  }

  @Bean
  public JmsTemplate jmsTemplate () {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setConnectionFactory(connectionFactory());
    jmsTemplate.setPubSubDomain(true);
    return jmsTemplate;
  }
}
