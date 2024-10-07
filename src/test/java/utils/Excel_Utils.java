package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {

    public static void main(String[] args) {
//        getRowCount();
        getCellDataString();
        getCellDataNumeric();
    }

    //Get Row Count
    public static void getRowCount(){
        try{

            //Path of project
            String projectPath = System.getProperty("user.dir");
            //Step 1: Create reference for excel workbook (Path is D:\selenium with java\Practise-Project1\excel\data.xlsx. But we can replace D:\selenium with java\Practise-Project1\ with projectPath variable)
            XSSFWorkbook workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");

            //Step 2: Create reference for worksheet
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            //Step 3: Call row count function
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No.of rows in the excel sheet: "+rowCount);

        }
      catch(Exception e){
          System.out.println(e.getMessage());
          System.out.println(e.getCause());
            e.printStackTrace();
      }

    }

    public static void getCellDataString(){
        try {

            //Path of project
            String projectPath = System.getProperty("user.dir");
            //Step 1: Create reference for excel workbook (Path is D:\selenium with java\Practise-Project1\excel\data.xlsx. But we can replace D:\selenium with java\Practise-Project1\ with projectPath variable)
            XSSFWorkbook workbook = new XSSFWorkbook(projectPath + "/excel/data.xlsx");

            //Step 2: Create reference for worksheet
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            //Step 3: Call function to get cell data
            String cellData = sheet.getRow(0).getCell(0).getStringCellValue();
            System.out.println(cellData);


        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    //If we have numeric data in a cell

    public static void getCellDataNumeric(){
        try {

            //Path of project
            String projectPath = System.getProperty("user.dir");
            //Step 1: Create reference for excel workbook (Path is D:\selenium with java\Practise-Project1\excel\data.xlsx. But we can replace D:\selenium with java\Practise-Project1\ with projectPath variable)
            XSSFWorkbook workbook = new XSSFWorkbook(projectPath + "/excel/data.xlsx");

            //Step 2: Create reference for worksheet
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            //Step 3: Call function to get cell data
            double cellData = sheet.getRow(1).getCell(1).getNumericCellValue();
            System.out.println(cellData);


        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
