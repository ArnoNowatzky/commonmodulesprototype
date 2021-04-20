package de.noventi.cm.client.java;

import de.noventi.cm.client.java.service.ApiException;
import de.noventi.cm.client.java.service.api.CustomerApi;
import de.noventi.cm.client.java.service.model.CustomerDTO;
import java.io.File;
import java.lang.management.ManagementFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class AutomaticClient {

  private final static int NUMBER_SERVICECALLS = 10;

  /**
   * starts the automatic client
   * @param args     arguments: [UUID] [FOLDER]
   */
  public static void main(String[] args) throws ApiException {
    try {
      String uuid = args[0];
      String folderName = args[1];

      MDC.put("process_id", ManagementFactory.getRuntimeMXBean().getName());


      Services services = new Services();
      File folder = new File(folderName);
      log.info("Started client with UUID " + uuid + " and folder " + folder.getAbsolutePath());
      ApplicationContext.login(ApplicationContext.getMandantID(), "chef", "chef");

      Durations durationsService = new Durations();

      CustomerApi customerApi = services.getCustomerApi(Services.BASEURL_SERVICE_LOCAL);
      for (int i = 0; i < NUMBER_SERVICECALLS; i++) {
        String id = String.format("%04d", i);
        String searchedId = String.valueOf(i);
        durationsService.start(id);
        CustomerDTO customer = customerApi.getCustomer(searchedId);
        durationsService.stop(id);

        if (!customer.getFirstname().equals("Sherlock " + i))
          throw new IllegalStateException("Error on " + i + ". servicecall, firstname " + customer.getFirstname() + " does not match the expected name");
      }

      durationsService.save(new File (folder, "service_" + ProcessHandle.current().pid() + "_" + uuid));

    } catch (Exception e) {
      log.error("Error occurred: " + e.getLocalizedMessage(), e);
      System.exit(1);
    }

  }
}
