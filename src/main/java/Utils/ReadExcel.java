package Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {

        String fileLocation = "./Test-Data/Login-data.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(fileLocation);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= 2; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 2; j++) {
                XSSFCell cell = row.getCell(j);
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        }
    }
}



