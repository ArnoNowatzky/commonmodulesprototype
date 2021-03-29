package de.noventi.cm.runtime.module.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModuleStatus {

  private String instanceId; //e.g. PID or Container ID

  private boolean isRunning;
}
