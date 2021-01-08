package de.noventi.cm.runtime.module.domain;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class SetupModulesParamReader {

  public CommonModules read (String descriptor) {
    descriptor = descriptor.replace("~", System.getProperty("user.home"));
    try {
      JAXBContext context = JAXBContext.newInstance(CommonModules.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      return (CommonModules) unmarshaller.unmarshal(new StringReader(descriptor));
    } catch (JAXBException e) {
      throw new IllegalStateException("Error reading setup modules param reader: " + e.getLocalizedMessage(), e);
    }
  }
}
