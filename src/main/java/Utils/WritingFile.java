package Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingFile {
    @Test
    public void write() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("EMP SHEET");
        Object empdata[][] = {{"emp id", "Name", "role"},
                {101, "david", "Engineer"},
                {102, "sutan", "manager"},
                {103, "iniya", "manager"}};
        int rowCount = 0;
        for (Object emp[] : empdata) {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object value : emp) {
                XSSFCell cell = row.createCell(columnCount++);
                if (value instanceof String) cell.setCellValue((String) value);
                if (value instanceof Integer) cell.setCellValue((Integer) value);
                if (value instanceof Boolean) cell.setCellValue((Boolean) value);
            }
        }
        String filepath = "Test-Data/emailid.xlsx";
//it will create file and write to it.
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        workbook.write(outputStream);
        outputStream.close();
    }
}
