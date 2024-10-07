package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {


    //Step 12

    WebDriver driver=null;
    @BeforeTest
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }



    //Section 3: How to get test data from excel

    //Section 3: How to get test data from excel - Step 10:Create a function and profide testNG annotation

    //test1data is the dataprovider name we gave
    @Test(dataProvider="test1data")
    //Section 3: How to get test data from excel - Step 11:add column names

    public void test1(String username, String password) throws Exception{
        System.out.println(username+" | "+password);

        //Step 13
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(5000);
    }

    //Section 2: How to use testNG data provider - Step 8:Create  function and call testng annotation
    @DataProvider(name = "test1data")
    public static Object[][] getData(){

        //Section 2: How to use testNG data provider - Step 9: Call excel data provider function and return the data object
        String excelPath = "D:/selenium with java/Practise-Project1/excel/data.xlsx";
       Object data[][] =  testData(excelPath,"Sheet1");
        return data;
    }
    public static Object[][] testData(String excelPath, String sheetName){ //Step 7: change void to Object[][]
         //Step 1: Create object for class
        Excel_Utils_CallExcelFunctions_TestNG excel = new Excel_Utils_CallExcelFunctions_TestNG(excelPath, sheetName);

        //Step 2: Get row count and column count
        int rowCount = excel.getRowCount();
        int colCount = excel.getColumnCount();

        //Step 4: Define an object array (Creatng a two dimensional array where the size equals to rowcount-1 and colcount-1 because 1st row is header

        Object data[][] = new Object[rowCount-1][colCount];

        //Step 3: Run a loop to get all data
        for(int i=1; i<rowCount; i++){
            for (int j=0; j<colCount; j++){
                String cellData = excel.getCellDataString(i, j);
//                System.out.println(cellData+" | ");

                //step5: adding data to object array
                data[i-1][j]=cellData;
            }
//            System.out.println();
        }
        //Stp 6: Returning the array
        return data;
    }
}
