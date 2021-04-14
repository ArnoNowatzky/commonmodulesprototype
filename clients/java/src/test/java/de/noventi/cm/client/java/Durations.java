package de.noventi.cm.client.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;


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
    List<Duration> sorted = new ArrayList<Duration>(durations.values());
    Collections.sort(sorted);
    return sorted.toString();
  }
}
