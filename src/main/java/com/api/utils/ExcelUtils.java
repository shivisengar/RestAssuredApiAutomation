package com.api.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    public static Map<String, String> getRowData(String excelPath,
                                                 String sheetName,
                                                 int rowNum) {

        Map<String, String> data = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("createUsers");

            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowNum);

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).getStringCellValue();
                String value = dataRow.getCell(i).getStringCellValue();
                data.put(key, value);
            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
