package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    // define webelement as a class variable. So we dont't have to define it in every function
    //private is used to make the variable available only to this class
    private static WebElement element =null;

    //Returning the variable which is of type WebElement (Return type of the function is defined as WebElement after public static instead of void)
    public static WebElement textbox_search(WebDriver driver){
        element = driver.findElement(By.name("q"));
        return element;
    }

    public static WebElement button_search(WebDriver driver){
        element = driver.findElement(By.name("btnK"));
        return element;
    }
}
