package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentReportsExample_WithTestNG {

    static WebDriver driver;

    //make the variables in global level because we use them in several test classes
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;

    //BeforeSuite is used to Run before all test cases in the class. If we use beforeTest, this will run before each test case in the class
    @BeforeSuite
    public void setUp(){
        htmlReporter = new ExtentSparkReporter("target/extentReports/extentReportswithTestNG.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1(){
    ExtentTest test = extent.createTest("My first test", "sample");

    driver.get("https://www.google.com/");
    test.pass("Navigated to Google.com");
        driver.findElement(By.name("q")).sendKeys("Manual testing");
        test.pass("Entered text in search box");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        test.pass("Pressed enter");

        test.info("Test Completed");

    }

    @Test
    public void test2(){
        ExtentTest test = extent.createTest("My first test", "sample");

        test.log(Status.INFO, "This step shows the usage of log(status, details)");
        test.info("This step shows the usage of info(details)");
        test.pass("Test passing");

        //attach a screenshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
    }


    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        System.out.println("Test was Completed successfully");
    }

    //AfterSuite is used to Run after all test cases in the class. If we use afterTest, this will run after each test case in the class
    @AfterSuite
    public void tearDown(){
        extent.flush();
    }
}
