package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_XML_GoogleSearch {

    static WebDriver driver;

    @BeforeTest
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch(){

       driver.get("https://www.google.com/");


    }

    @AfterTest
    public void tearDownTest(){

        driver.close();
        driver.quit();
        System.out.println("Test was Completed successfully");

    }
}

/*
To generate a testoutput report, go to Edit configurations infront of the run button is ide ribbon -> Listeneres
 and tick the checkbox of Use default reporters
 */