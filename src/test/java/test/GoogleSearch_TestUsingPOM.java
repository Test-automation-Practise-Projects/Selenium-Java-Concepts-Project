package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//importing the pages class
import pages.GoogleSearchPage;

public class GoogleSearch_TestUsingPOM {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        googleSearch();
    }

    public static void googleSearch(){
        WebDriverManager.chromedriver().setup();
         driver =new ChromeDriver();

        driver.get("https://www.google.com/");

        GoogleSearchPage.textbox_search(driver).sendKeys("Automation steps");
        GoogleSearchPage.textbox_search(driver).sendKeys(Keys.ESCAPE);
        GoogleSearchPage.button_search(driver).click();

        System.out.println("Test Completed successfully");
    }
}
