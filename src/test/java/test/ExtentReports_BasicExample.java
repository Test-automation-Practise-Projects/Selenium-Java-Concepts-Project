package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReports_BasicExample {

    private static WebDriver driver = null;

    public static void main(String[] args) {
        //Create a location to store the report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extentReports/extentReports.html");

        //Create ExtentReports and attach reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //Giving a topic and description for the report
        ExtentTest test1 = extent.createTest("Google Search Test1", "Test to validate Google search functionality");

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        //log with info tag
        test1.log(Status.INFO,"Starting test case");

        //pass tag
        driver.get("https://www.google.com/");
        test1.pass("Navigated to Google.com");

        driver.findElement(By.name("q")).sendKeys("Manual testing");
        test1.pass("Entered text in search box");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        test1.pass("Pressed enter");

        test1.info("Test Completed");





        //show a failure
        ExtentTest test2 = extent.createTest("Google Search Test2", "Test to validate Google search functionality");
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        test2.log(Status.INFO,"Starting test case");
        driver.get("https://www.google.com/");
        test2.pass("Navigated to Google.com");
        driver.findElement(By.name("q")).sendKeys("Manual testing");
        test2.pass("Entered text in search box");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //log with fail tag
        test2.fail("Pressing enter fails");
        test2.info("Test Completed");




        //Write everyting to the report or to the logs
        extent.flush();

    }
}
