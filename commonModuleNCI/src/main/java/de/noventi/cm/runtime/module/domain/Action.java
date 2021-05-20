package de.noventi.cm.runtime.module.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Action {
  INSTALL,
  UNINSTALL
}
