package de.noventi.cm.runtime.api;

import de.noventi.cm.runtime.domain.module.CommonModule;
import java.io.File;

public interface Installer {

  void install (File path, CommonModule module);

  void start (File path, CommonModule module);
}
