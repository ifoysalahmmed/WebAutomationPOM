package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
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

    public void writeOnElement (By locator, String text) {
        getWebElement (locator).clear ();
        getWebElement (locator).sendKeys (text);
    }

    public Boolean getDisplayState (By locator) {
        try {
            return getDriver ().findElement (locator).isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAttribute (By locator, String attribute) {
        return getWebElement (locator).getAttribute (attribute);
    }

    public String getElementText (By locator) {
        return getWebElement (locator).getText ();
    }

    public void addScreenshot (String name) {
        Allure.addAttachment (name,
                new ByteArrayInputStream (((TakesScreenshot) getDriver ()).getScreenshotAs (OutputType.BYTES)));
    }
}