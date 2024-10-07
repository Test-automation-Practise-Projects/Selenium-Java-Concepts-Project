package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

    public static void main(String[] args) {

        googleSearch();
    }

    public static void googleSearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        //Go to Google page
                driver.get("https://www.google.com/");

        //Enter search
        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("Automation Step by step");


        // Search
            //textBox.sendKeys(Keys.RETURN);

        // Press Escape to close the dropdown and then click the search button
                textBox.sendKeys(Keys.ESCAPE);
                // Click on Search button
                         driver.findElement(By.name("btnK")).click();
               //OR
                // Hit enter
                        //driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

        System.out.println("Test Completed successfully");
    }
}
