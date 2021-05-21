package de.noventi.cm.wawi.java;

import de.noventi.cm.wawi.java.example.ApiClient;
import de.noventi.cm.wawi.java.example.api.MedicationsApi;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Services {

  public final static String BASEURL_SERVICE_LOCAL = "https://localhost:8002";

  public MedicationsApi getCustomerApi (final String basePath) {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath(basePath);

    try {

      FileInputStream fileInputStream = new FileInputStream(new File("build/example/jar/keystore/commonmodule.p12"));
      KeyStore ks = KeyStore.getInstance("PKCS12");
      ks.load(fileInputStream, "commonmodule".toCharArray());
      Certificate cerificate = ks.getCertificate("commonmodule");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cerificate.getEncoded());
      apiClient.setSslCaCert(byteArrayInputStream);
      MedicationsApi customerApi = new MedicationsApi(apiClient);
      if (ApplicationContext.getToken() != null) {
        log.info("Add token " + ApplicationContext.getToken());
        customerApi.getApiClient().addDefaultHeader("Authorization", "Bearer " + ApplicationContext.getToken());
      } else
        log.info("No token available");

      return customerApi;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
