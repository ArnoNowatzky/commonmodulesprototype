package de.noventi.cm.wawi.java;

import org.jetbrains.annotations.NotNull;

public class Duration implements Comparable<Duration>  {

  private String id;

  private long from;

  private long until;

  public String toString() {
    return "\n" + id + " : " + (until - from);
  }

  @Override public int compareTo(@NotNull Duration o) {
    return id.compareTo(o.id);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getFrom() {
    return from;
  }

  public void setFrom(long from) {
    this.from = from;
  }

  public long getUntil() {
    return until;
  }

  public void setUntil(long until) {
    this.until = until;
  }
}
