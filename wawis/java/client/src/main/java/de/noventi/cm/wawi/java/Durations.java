package de.noventi.cm.wawi.java;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import org.apache.commons.io.FileUtils;

public class Durations {

  @Getter

  private HashMap<String, Duration> durations = new HashMap<>();

  public void start (final String id) {
    Duration duration = new Duration();
    duration.setId(id);
    durations.put(id, duration);
    duration.setFrom(System.currentTimeMillis());
  }

  public void stop (final String id) {
    Duration duration = durations.get(id);
    if (duration == null)
      throw new IllegalStateException("No duration for id " + id + " found: " + durations);
    duration.setUntil(System.currentTimeMillis());
  }

  public String toString () {

    System.out.println (durations);
    List<Duration> sorted = new ArrayList<Duration>(durations.values());
    Collections.sort(sorted);
    return sorted.toString();
  }

  public File save (final File toFile) {
    toFile.getParentFile().mkdirs();
    try {
      FileUtils.writeStringToFile(toFile, toString().replace("[\n", "").replace("]","").replace(",",""), Charset.defaultCharset());
      return toFile;
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
