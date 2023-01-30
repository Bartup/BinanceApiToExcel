package org.example.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelHandler {

    public static void exportToExcel(ArrayList<Kline> klines) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet spreadsheet
                = workbook.createSheet("BinanceData");

        XSSFRow row;
        int rowid = 0;
        row = spreadsheet.createRow(rowid++);

        String[] titles = {"PAIR", "OPENING DATE", "LOW", "HIGH", "CURRENT", "OPEN", "GROWTH", "FALL", "LOW DATE"};

        for(int i = 0; i < 9; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }

        for (Kline kline : klines) {
            row = spreadsheet.createRow(rowid++);

            Cell cell = row.createCell(0);
            cell.setCellValue(kline.name);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(kline.openingDate.toString().substring(0, kline.openingDate.toString().length() - 12));

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(kline.low);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(kline.high);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(kline.current);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(kline.open);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(kline.growth);

            Cell cell7 = row.createCell(7);
            cell7.setCellValue(kline.fall);

            Cell cell8 = row.createCell(8);
            cell8.setCellValue(kline.lowestDate.toString());
        }

        FileOutputStream out = new FileOutputStream(
                new File("/Volumes/Bartek/JavaProjects/BinanceApiTesting/src/output/" + System.currentTimeMillis() + ".xlsx"));
        workbook.write(out);
        out.close();
    }
}
