package com.nawasrah.schoolMS.test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ExcelUtils {

    public static List<Map<String, String>> readExcel(InputStream inputStream) throws IOException {


        List<Map<String, String>> dataList = new ArrayList<>(); // create a list of maps to store data from all rows
        try {
            Workbook workbook =  WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // assuming first sheet is used
            Iterator<Row> rowIterator = sheet.iterator();

            // iterate over all the rows in the sheet
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                Map<String, String> dataMap = new HashMap<>(); // create a new map for each row

                // iterate over all the cells in the row and populate the data map
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    int columnIndex = currentCell.getColumnIndex();
                    String header = sheet.getRow(0).getCell(columnIndex).getStringCellValue(); // get the header from the first row of the column
                    String value = null;
                    switch (currentCell.getCellType()) { // get the value from the current cell based on its type
                        case STRING:
                            value = currentCell.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = String.valueOf(currentCell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            value = String.valueOf(currentCell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            value = currentCell.getCellFormula();
                            break;
                        default:
                            value = "";
                            break;
                    }
                    dataMap.put(header, value); // put the value in the map with the corresponding header as the key
                }
                dataList.add(dataMap); // add the map to the list of maps
            }

            workbook.close(); // close the workbook to release resources
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print out the data list to verify it
        System.out.println(dataList);
        return dataList;
    }
}