package com.chimera.i3LocalLevelEvents;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 

public class GetExcelSheetData {

    @SuppressWarnings("resource")
    public String getSheetData(String sheetName, int row, int cell) throws Throwable {

        String workingDir = System.getProperty("user.dir");
        String excelpath = workingDir + "\\src\\test\\resources\\data\\em\\TestData.xlsx";

        FileInputStream fs = new FileInputStream(excelpath);
        Cell stringCellValue = new XSSFWorkbook(fs).getSheet(sheetName).getRow(row).getCell(cell);
        DataFormatter df = new DataFormatter();
        String formatCellValue = df.formatCellValue(stringCellValue);
        return formatCellValue;
    }

}