package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    LoginPage login = new LoginPage ();
    HomePage home = new HomePage ();

    @BeforeClass
    public void loadPage () {
        login.navigateToLoginPage ();
    }

    @Test
    public void test_login_with_valid_credentials () {
        login.writeOnElement (login.login_email, "shobuj@yopmail.com");
        login.writeOnElement (login.login_password, "shobuj123");
        login.clickOnElement (login.login_button);
        Assert.assertTrue (login.getDisplayState (home.logout_button));
        Assert.assertFalse (login.getDisplayState (login.login_button));
    }

    @Test
    public void test_login_with_invalid_password () {
        login.writeOnElement (login.login_email, "shobuj@yopmail.com");
        login.writeOnElement (login.login_password, "shobuj122");
        login.clickOnElement (login.login_button);
        Assert.assertEquals (login.getElementText (login.error_message), "Your email or password is incorrect!");
        Assert.assertTrue (login.getDisplayState (login.login_button));
    }

    @Test
    public void test_login_with_invalid_email () {
        login.writeOnElement (login.login_email, "shobujh");
        login.writeOnElement (login.login_password, "shobuj123");
        login.clickOnElement (login.login_button);
        Assert.assertEquals (login.getAttribute (login.login_email, "validationMessage"),
                "Please include an '@' in " + "the email address. 'shobujh' is missing an '@'.");
        Assert.assertTrue (login.getDisplayState (login.login_button));
    }
}