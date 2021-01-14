package de.noventi.cm.client.java;

import de.noventi.cm.client.java.runtime.ApiClient;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdminControllerTest {

  @BeforeAll
  public static void beforeAll () throws IOException {
    deleteExample();
  }

  /**@AfterAll
  public static void afterAll () throws IOException {
    deleteExample();
  }**/



  private static void deleteExample () throws IOException {
    File path = new File ("build/example");
    if (path.exists())
      FileUtils.forceDelete(path);
  }

  @Test
  public void install () {

    AdminController controller = new AdminController();
    controller.install();


  }
}
