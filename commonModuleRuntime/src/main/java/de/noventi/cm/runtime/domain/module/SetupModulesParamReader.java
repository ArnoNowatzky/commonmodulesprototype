package de.noventi.cm.runtime.domain.module;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class SetupModulesParamReader {

  public CommonModules read (final String descriptor) {
    try {
      JAXBContext context = JAXBContext.newInstance(CommonModules.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      return (CommonModules) unmarshaller.unmarshal(new StringReader(descriptor));
    } catch (JAXBException e) {
      throw new IllegalStateException("Error reading setup modules param reader: " + e.getLocalizedMessage(), e);
    }
  }
}
