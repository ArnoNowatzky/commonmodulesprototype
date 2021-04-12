package de.noventi.cm.runtime;

import de.noventi.cm.runtime.monitoring.MonitoringRuntime;
import org.junit.jupiter.api.Test;

public class MonitoringRuntimeTest {

  @Test
  public void call () {
    MonitoringRuntime monitoringRuntime = new MonitoringRuntime();
    monitoringRuntime.sendData();

  }
}
