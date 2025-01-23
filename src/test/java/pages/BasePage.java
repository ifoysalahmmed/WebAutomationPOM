package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getWebElement (By locator) {
        WebDriverWait wait = new WebDriverWait (getDriver (), Duration.ofSeconds (10));
        return wait.until (ExpectedConditions.presenceOfElementLocated (locator));
    }

    public void clickOnElement (By locator) {
        WebDriverWait wait = new WebDriverWait (getDriver (), Duration.ofSeconds (10));
        wait.until (ExpectedConditions.elementToBeClickable (locator)).click ();
    }

    public void loadAWebPage (String URL) {
        getDriver ().get (URL);
    }
}