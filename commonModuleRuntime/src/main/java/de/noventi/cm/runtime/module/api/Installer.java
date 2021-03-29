package de.noventi.cm.runtime.module.api;

import de.noventi.cm.runtime.module.domain.CommonModule;
import java.io.File;

public interface Installer {

  void install (File path, CommonModule module);

  void start (File path, CommonModule module);

  void stop (File path, CommonModule module);

  ModuleStatus getState (File path, CommonModule module);
}
