package de.noventi.cm.client.java;

import de.noventi.cm.client.java.service.ApiException;
import de.noventi.cm.client.java.service.api.CustomerApi;
import de.noventi.cm.client.java.service.model.CustomerDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j public class ServicePerformanceTest {

  public int NUMBER_CLIENTS = 10;
  public int NUMBER_CALLS = 100;
  public boolean withoutDatabase = true;

  private Services services = new Services();

  @BeforeAll public static void before() {
    ApplicationContext.login(ApplicationContext.getMandantID(), "chef", "chef");
  }

  @AfterAll public static void after() {
    ApplicationContext.logout();
  }

  @Test public void testSequentialCallService() {

    Durations durations = new Durations();
    CustomerApi customerApi = services.getCustomerApi(Services.BASEURL_SERVICE_LOCAL);
    CustomerDTO customer = null;
    try {
      log.info(customerApi.getApiClient().getBasePath());

      for (int i = 0; i < NUMBER_CALLS; i++) {
        String id = String.format("%04d", i);
        String searchedId = withoutDatabase ? ("W" + String.valueOf(i)): String.valueOf(i);
        durations.start(id);
        customer = customerApi.getCustomer(searchedId);
        durations.stop(id);
        Assertions.assertEquals("Sherlock " + i, customer.getFirstname());
      }

      log.info("Durations: " + durations);
    } catch (ApiException e) {
      log.info(e.getResponseBody() + "-" + e.getCode() + ":" + e.getMessage());
      throw new IllegalStateException(e.getResponseBody() + ":" + e.getMessage(), e.getCause());
    }

  }

  @Test public void testParallelCallService() throws InterruptedException {

    List<Callable<Void>> callableTasks = new ArrayList<>();

    Durations durations = new Durations();
    final CustomerApi customerApi = services.getCustomerApi(Services.BASEURL_SERVICE_LOCAL);

    log.info(customerApi.getApiClient().getBasePath());

    for (int i = 0; i < NUMBER_CALLS; i++) {
      final int increment = i;
      callableTasks.add(new Callable<Void>() {
        @Override public Void call() throws Exception {
          String id = String.format("%04d", increment);
          String searchedId = withoutDatabase ? ("W" + String.valueOf(increment)): String.valueOf(increment);
          durations.start(id);
          CustomerDTO customer = customerApi.getCustomer(searchedId);
          durations.stop(id);
          Assertions.assertEquals("Sherlock " + increment, customer.getFirstname());
          return null;
        }
      });
    }

    log.info("Created " + callableTasks.size() + " callables");

    ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_CLIENTS);
    executorService.invokeAll(callableTasks);
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.SECONDS);

    log.info("Durations: " + durations);
  }


}
