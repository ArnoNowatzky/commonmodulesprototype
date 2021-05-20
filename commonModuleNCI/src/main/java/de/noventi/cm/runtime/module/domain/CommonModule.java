package de.noventi.cm.runtime.module.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CommonModule {

  @XmlElement(required = true)
  private String id;

  @XmlElement(required = true)
  private Action action;

  @XmlElement(required = true)
  private Type type;

  @XmlElement(required = true)
  private String name;

  @XmlElement
  private String url;

  @XmlElement
  private String jdk; //jdk8 or jdk11....

  @XmlElement
  private String description;

  @XmlElement
  private boolean sql;
}
