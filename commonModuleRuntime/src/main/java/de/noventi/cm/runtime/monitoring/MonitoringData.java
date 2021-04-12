package de.noventi.cm.runtime.monitoring;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import liquibase.pro.packaged.T;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;

@Slf4j
@ToString
@Data
public class MonitoringData {

  private long availableMemory;

  private long totalMemory;

  private String computerSystemManufacturer;

  private String computerSystemModel;
  private String computerSystemReleaseDate;
  private String computerSystemSerialNumber;

  private long diskSpaceTotal;
  private long diskSpaceFree;

  private String processor;

  private int physicalCPUs;
  private int physicalCores;
  private int logicalCPUs;

  private double temperature;

  private String runtimeVersion;

  public MonitoringData () {
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.getOperatingSystem().getFamily();
    HardwareAbstractionLayer hardware = systemInfo.getHardware();

    GlobalMemory memory = hardware.getMemory();
    availableMemory = memory.getAvailable();
    totalMemory = memory.getTotal();

    log.info("Available memory " + (availableMemory * 100 / totalMemory) + "%");

    ComputerSystem computerSystem = hardware.getComputerSystem();
    computerSystemManufacturer = computerSystem.getManufacturer();
    computerSystemModel = computerSystem.getModel();
    computerSystemReleaseDate = computerSystem.getFirmware().getReleaseDate();
    computerSystemSerialNumber = computerSystem.getSerialNumber();

    for (HWDiskStore nextDiskStore: hardware.getDiskStores()) {
      log.info("DiskStore " + nextDiskStore.getName());
      log.info("Timestamp " + nextDiskStore.getTimeStamp());
      for (HWPartition next: nextDiskStore.getPartitions()) {
        log.info("   Name      : " + next.getName());
        log.info("   MountPoint: " + next.getMountPoint());
        log.info("   Size      : " + next.getSize());
      }
    }

    File file = new File ("").getAbsoluteFile();
    diskSpaceTotal = file.getTotalSpace();
    diskSpaceFree = file.getFreeSpace();

    CentralProcessor processor = hardware.getProcessor();
    this.processor = processor.getProcessorIdentifier().getName();

    this.logicalCPUs = processor.getLogicalProcessorCount();
    this.physicalCores = processor.getPhysicalPackageCount();
    this.physicalCPUs = processor.getPhysicalProcessorCount();

    this.temperature = hardware.getSensors().getCpuTemperature();

    InputStream resourceAsStream = getClass().getResourceAsStream("/runtime.version");
    if (resourceAsStream != null) {
      try {
        this.runtimeVersion = IOUtils.toString(resourceAsStream, Charset.defaultCharset());
      } catch (IOException e) {
        this.runtimeVersion = e.getMessage();
      }

    }

    log.info("Available diskspace " + (diskSpaceFree * 100 / diskSpaceTotal) + "%");
  }


}
