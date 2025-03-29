package testcases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage ();

    @Test(description = "Test Home Page Title")
    @Description("User trying to verify the home page title")
    public void testHomePageTitle () {
        homePage.loadAWebPage (homePage.homepageURL);
        homePage.addScreenshot ("Home Page");
        Assert.assertEquals (getDriver ().getCurrentUrl (), homePage.homepageURL);
    }
}