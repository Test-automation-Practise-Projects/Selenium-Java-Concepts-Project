package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils_CallExcelFunctions {

    //Declared globally because we use them in multiple functions
    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    //Step 2: Create constrcutor
    //Step 3: Parametrize the constructor to get excel name and sheet name
    public Excel_Utils_CallExcelFunctions(String excelPath, String sheetName){

        try{
            projectPath = System.getProperty("user.dir");
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //pass arguments as rownumbers and column numbers
    public static void main(String[] args) {
        getCellDataString(0,0);
        getCellDataNumeric(1,1);

    }


    //Step 1: getting rowNum and colNum without hardcoding them as we did in Excel_Utils file
    public static void getCellDataString(int rowNum, int colNum){
        try {
            String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println(cellData);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    //If we have numeric data in a cell

    public static void getCellDataNumeric(int rowNum, int colNum){
        try {
            double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellData);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }


}

//Step 4: Create a new class to call excel functions - created as ExcelUtilsClass