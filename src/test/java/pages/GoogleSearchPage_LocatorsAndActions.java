package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage_LocatorsAndActions {

    // Locators
    WebDriver driver = null;
    By textbox_search = By.name("q");
    By button_search = By.name("btnK");

    /*
    Used a driver in WebDriver driver = null; but when this is called from a test case,
    we have to use the driver instance from the test case and not from this  WebDriver driver = null;.
    Otherwise it will not do any action
     */
    // So creating a Constructor(Use the same class name, getting the webdriver instance from the calling class.)So, wherever we create an object for this class, this constructor will be called. Also whenever we create an object of this class, we are passing a driver instance within the brackets.
    public GoogleSearchPage_LocatorsAndActions(WebDriver driver) {
        this.driver = driver;

        /*
        this.driver means because I'm taking the same name driver within brackets and I have already given a name driver in     WebDriver driver = null; line as well.
        So to make Java understand I'm saying in this.driver = driver;, I'm referencing to driver of this particular class which is driver in WebDriver driver = null and
                this.driver = driver; should be given the value of the driver that is coming as a argument to the constructor within brackets
         For example, we can do as below as well:
         public GoogleSearchPage_LocatorsAndActions(WebDriver driver1) {
        driver = driver1;
         */

    }

    // Actions
    public void setTextInSearchBox(String text){ //get the passed value in the test case
        driver.findElement(textbox_search).sendKeys(text);
    }

    public void closeDropdownMenu(){
        driver.findElement(textbox_search).sendKeys(Keys.ESCAPE); // Close dropdown if it's open
    }

    public void clickSearchButton(){
        WebElement searchButton = driver.findElement(button_search);
        searchButton.click();
    }


}
