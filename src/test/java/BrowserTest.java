import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class BrowserTest {
    public static void main(String[] args) {

        //WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        //If we want to give the version of the chrome driver, use below code:
             //WebDriverManager.chromedriver().browserVersion("127.0.6533.120").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement textBox = driver.findElement(By.id("APjFqb"));
                textBox.sendKeys("Automation");
        //using xpath
                //WebElement textBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));

        //Same functionality in one line
                //driver.findElement(By.id("APjFqb")).sendKeys("Automation");

        //List the count of all elements that are of the type 'input'
                //List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
                //int count = listOfInputElements.size();
                //System.out.println("Count of input elements:  "+count);

        //Close browser
                //driver.close();

        //driver.quit();
    }
}
