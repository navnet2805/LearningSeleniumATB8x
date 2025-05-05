package Data_Driven_Testing.TestCases;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        //Workbook -> Sheet -> Row -> Cell

        String excel_file_path = "C:\\Users\\naveen.rp\\IdeaProjects\\LearningSeleniumATB8x\\src\\test\\java\\Data_Driven_Testing\\TestData\\Data.xlsx";

        FileInputStream file = new FileInputStream(excel_file_path);

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int number_of_rows = sheet.getLastRowNum();
        int number_of_cell = sheet.getRow(1).getLastCellNum();

        System.out.println("number_of_cell : " +number_of_cell); //4
        System.out.println("number_of_rows : " +number_of_rows); //5 //row will always starts with zero

        for (int row=0 ; row<=number_of_rows ; row++)
        {
            XSSFRow current_row = sheet.getRow(row);
            for (int cell=0 ; cell<number_of_cell ; cell++)
            {
                XSSFCell current_cell = current_row.getCell(cell);
                System.out.print(current_cell+"\t");
            }
            System.out.println();
        }

        file.close();
        workbook.close();
    }
}
