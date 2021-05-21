package de.noventi.cm.wawi.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.LineChartSeries;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;

public class CreateDiagram {


  private List<File> getMeasurements(final File path) {
    if (path == null)
      throw new IllegalArgumentException("Argument " + path + " must not be null");
    List<File> files = new ArrayList<>();

    if (path.getAbsoluteFile().listFiles() == null)
      throw new IllegalStateException("Path " + path.getAbsolutePath() + " does not contain files");



    for (File next : path.getAbsoluteFile().listFiles()) {
      if (!next.isDirectory())
        files.add(next);
    }

    return files;
  }

  public void createDiagram(final File path) {
    System.out.println("Create diagram for " + path.getAbsolutePath());
    Workbook wb = new XSSFWorkbook();
    Sheet sheet = wb.createSheet("Sheet1");

    int minimalInt = -1;
    int maximalInt = -1;
    int averageInt = -1;
    int averageInitializedInt = -1;

    Row row;
    Cell cell;

    row = sheet.createRow(0);
    row.createCell(0).setCellValue("Index");

    List<File> measurements = getMeasurements(path);

    for (int i = 0; i < measurements.size(); i++) {
      File next =  measurements.get(i);
      String[] tokens = next.getName().split("_");
      row.createCell(1 + i).setCellValue(tokens[1]);
    }

    HashMap<String, Row> rowHashMap = new HashMap<>();
    for (int i = 0; i < measurements.size(); i++) {
      String content;
      File measurementFile = measurements.get(i);
      try {
        content = FileUtils.readFileToString(measurementFile, Charset.defaultCharset());
      } catch (IOException e) {
        throw new IllegalStateException("Error reading file " + path.getAbsolutePath());
      }
      String[] lines = content.split("\n");

      for (int r = 0; r < lines.length; r++) {
        String[] tokens = lines[r].split(":");
        String key = tokens[0];
        int value = Integer.valueOf(tokens[1].trim());

        Row currentRow = rowHashMap.get(key);
        if (currentRow == null) {
          currentRow = sheet.createRow(r+1);
          Cell indexCell = currentRow.createCell(0);
          indexCell.setCellValue(key);
          rowHashMap.put(key, currentRow);
        }

        Cell valueCell = currentRow.createCell(i + 1);
        valueCell.setCellValue(value);
        if (minimalInt < 0 || value < minimalInt)
          minimalInt = value;
        if (maximalInt < 0 || value > maximalInt)
          maximalInt = value;
        averageInt += value;
        if (r > 0)
          averageInitializedInt += value;
      }

    }

    averageInt = averageInt / (measurements.size() * rowHashMap.size());
    averageInitializedInt = averageInitializedInt / ((measurements.size() - 1) * rowHashMap.size());

    XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
     ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 12, 0, 28, 40);

     XSSFChart chart = drawing.createChart(anchor);
     ChartLegend legend = chart.getOrCreateLegend();
     legend.setPosition(LegendPosition.RIGHT);

     LineChartData data = chart.getChartDataFactory().createLineChartData();

     ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
     ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
     leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

     ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, rowHashMap.values().size() , 0, 0));
     for (int r = 0; r < measurements.size(); r++) {
       File measurementFile = measurements.get(r);
       String[] tokens = measurementFile.getName().split("_");
       String key = tokens[1];

       ChartDataSource<Number> y = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, rowHashMap.values().size(), r + 1, r + 1));
       LineChartSeries series = data.addSeries(xs, y);
       series.setTitle(key);
     }

     chart.plot(data, bottomAxis, leftAxis);

     XSSFClientAnchor rectangleanchor = new XSSFClientAnchor(0, 0, 0, 0, 17, 1, 20, 5);
     anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
     anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);

     XSSFSimpleShape rectangle = drawing.createSimpleShape(rectangleanchor);
     rectangle.setFillColor(220, 220, 220);
     rectangle.clearText();
     rectangle.addNewTextParagraph("Minimal: " + minimalInt + " ms");
     rectangle.addNewTextParagraph("Maximal: " + maximalInt + " ms");
     rectangle.addNewTextParagraph("Average: " + averageInt + " ms");
     rectangle.addNewTextParagraph("Average initialized: " + averageInitializedInt + " ms");


     XSSFChart xssfChart = (XSSFChart) chart;

     CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
     plotArea.getLineChartArray()[0].getSmooth();
     CTBoolean ctBool = CTBoolean.Factory.newInstance();
     ctBool.setVal(false);
     plotArea.getLineChartArray()[0].setSmooth(ctBool);
    for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
      ser.setSmooth(ctBool);
    }

    File report = new File("build/performance-report/" + path.getName() + ".xlsx").getAbsoluteFile();
    report.getParentFile().mkdirs();
    FileOutputStream fileOut = null;
    try {
      fileOut = new FileOutputStream(report);
      wb.write(fileOut);
      fileOut.close();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }
}
