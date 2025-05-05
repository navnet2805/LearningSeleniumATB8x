package Data_Driven_Testing.TestCases;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataToExcel {

    public static void main(String[] args) throws IOException {
        //Workbook -> Sheet -> Row -> Cell

        String excel_file_path = "C:\\Users\\naveen.rp\\IdeaProjects\\LearningSeleniumATB8x\\src\\test\\java\\Data_Driven_Testing\\TestData\\Data.xlsx";
        FileOutputStream file = new FileOutputStream(excel_file_path);

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Sheet2");

        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Name");
        row1.createCell(1).setCellValue("Age");
        row1.createCell(2).setCellValue("Place");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Naveen");
        row2.createCell(1).setCellValue("30");
        row2.createCell(2).setCellValue("Hospet");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("Pawan");
        row3.createCell(1).setCellValue("26");
        row3.createCell(2).setCellValue("Bangalore");

        workbook.write(file);
        file.close();
        workbook.close();
    }
}
