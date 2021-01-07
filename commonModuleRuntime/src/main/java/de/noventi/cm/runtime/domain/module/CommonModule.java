package de.noventi.cm.runtime.domain.module;

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
}
