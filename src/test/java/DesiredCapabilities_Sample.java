import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Sample {
    public static void main(String[] args) {

        // Set up DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();

        // Example Capabilities
        caps.setCapability("ms:loggingPrefs", "performance"); // Enable performance logging
        caps.setCapability("useAutomationExtension", false); // Disable automation extension message
        caps.setCapability("InPrivate", true); // Enable InPrivate mode

        // Set up EdgeOptions and merge with DesiredCapabilities
        EdgeOptions options = new EdgeOptions();
        options.merge(caps); // Merge DesiredCapabilities with EdgeOptions

        // Set up the Edge Driver with WebDriverManager
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);

        // Navigate to Google and perform a search
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Python testing");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        // Confirm InPrivate mode by checking the URL or behavior
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

    }
}
