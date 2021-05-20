package de.noventi.cm.runtime.monitoring;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class MonitoringRuntime {

  public static void main(String[] args) throws IOException {
    MonitoringRuntime monitoringRuntime = new MonitoringRuntime();
    monitoringRuntime.sendData();
  }

  public void sendData () {
    String key = null;
    try {
      key = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException e) {
      log.error(e.getMessage(), e);
    }


    MonitoringData monitoringData = new MonitoringData();
    log.info(monitoringData.toString());

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://vpcmawinta01-x.intra.vsa.de:9200/wawi/cm/"+ key;

    restTemplate.exchange(fooResourceUrl, HttpMethod.POST, new HttpEntity<MonitoringData>(monitoringData, createHeaders("elastic", "changeme")), MonitoringData.class);

  }

  public HttpHeaders createHeaders(String username, String password){
    return new HttpHeaders() {{
      String auth = username + ":" + password;
      byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")) );
      String authHeader = "Basic " + new String( encodedAuth );
      set( "Authorization", authHeader );
    }};
  }
}
