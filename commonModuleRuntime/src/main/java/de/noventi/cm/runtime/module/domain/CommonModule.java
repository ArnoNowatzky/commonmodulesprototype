package de.noventi.cm.runtime.module.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonModule {

  private String id;

  @XmlElement(required = true)
  private Action action;

  @XmlElement(required = true)
  private Type type;

  private String name;

  private String url;

  private String jdk; //jdk8 or jdk11....
}
