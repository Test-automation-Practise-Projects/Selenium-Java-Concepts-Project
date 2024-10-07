package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage_LocatorsAndActions;

public class GoogleSearch_TestWithPOMWithLocatorsandActions {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        googleSearchTest();
    }

    public static void googleSearchTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        GoogleSearchPage_LocatorsAndActions searchobj = new GoogleSearchPage_LocatorsAndActions(driver);

        driver.get("https://www.google.com/");

        searchobj.setTextInSearchBox("abcd");
        searchobj.closeDropdownMenu(); // Ensure dropdown is closed
        searchobj.clickSearchButton(); // Click the search button
    }
}
