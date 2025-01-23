package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    LoginPage login = new LoginPage ();

    @BeforeClass
    public void loadPage () {
        login.navigateToLoginPage ();
    }

    @Test
    public void test_login_with_valid_credentials () {
        System.out.println ("Test case started");
    }
}