package de.noventi.cm.client.java;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data public class Duration implements Comparable<Duration>  {

  private String id;

  private long from;

  private long until;

  public String toString() {
    return "\n" + id + "      : " + (until - from) + " ms";
  }

  @Override public int compareTo(@NotNull Duration o) {
    return id.compareTo(o.id);
  }
}
