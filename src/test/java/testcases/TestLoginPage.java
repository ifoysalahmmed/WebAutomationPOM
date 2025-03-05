package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    LoginPage login = new LoginPage ();
    HomePage home = new HomePage ();

    @BeforeMethod
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

    @Test(dataProvider = "invalidLoginData", dataProviderClass = utilities.DataSet.class)
    public void test_login_with_invalid_credentials (String email, String password, String errorMessage,
                                                     String emailValidationMessage, String passwordValidationMessage) {
        login.writeOnElement (login.login_email, email);
        login.writeOnElement (login.login_password, password);
        login.clickOnElement (login.login_button);
        Assert.assertEquals (login.getErrorMessage (errorMessage), errorMessage);
        Assert.assertEquals (login.getAttribute (login.login_email, "validationMessage"), emailValidationMessage);
        Assert.assertEquals (login.getAttribute (login.login_password, "validationMessage"), passwordValidationMessage);
        Assert.assertTrue (login.getDisplayState (login.login_button));
    }
}