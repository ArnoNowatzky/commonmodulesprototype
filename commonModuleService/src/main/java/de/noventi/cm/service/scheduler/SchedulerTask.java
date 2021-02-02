package de.noventi.cm.service.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerTask {

  @Autowired
  private CurrentTimeProducer currentTimeProducer;

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime () {
    String message = "The time on module service is now " + dateFormat.format(new Date());
    log.info(message);
    currentTimeProducer.sendMessage(message);
  }

}
