package test;

import config.PropertiesFile;
import demo.log4jSample;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_GoogleSearch_RelatedtoPropertiesfile {

     WebDriver driver=null;
     public static String browserName=null;

    private static Logger logger = LogManager.getLogger(log4jSample.class);


    @BeforeTest
    public void setupTest(){
        //calling get properties
        PropertiesFile.getProperties();


        //condition for opening the browser based on properties file
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Chrome Browser started");

        }

        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox Browser started");

        }
    }


    @Test
    public void googleSearch(){


       driver.get("https://www.google.com/");

        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("Automation Step by step");
        textBox.sendKeys(Keys.ENTER);

    }

    @AfterTest
    public void tearDownTest(){

        driver.close();
        System.out.println("Test was Completed successfully");

        //calling set properties
        PropertiesFile.setProperties();

    }
}

