package de.noventi.cm.runtime.domain.module;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name="modules")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CommonModules {

  @XmlElement(name = "module")
  private List<CommonModule> commonModule;
}
