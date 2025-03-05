package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public By login_email = By.xpath ("//input[@data-qa='login-email']");
    public By login_password = By.xpath ("//input[@placeholder='Password']");
    public By login_button = By.xpath ("//button[normalize-space()='Login']");
    public By error_message = By.xpath ("//p[normalize-space()='Your email or password is incorrect!']");


    HomePage homePage = new HomePage ();

    public void navigateToLoginPage () {
        homePage.loadHomePage ();
        homePage.clickOnElement (homePage.login_signup_button);
    }

    public String getErrorMessage (String errorMessage) {
        if (errorMessage.isEmpty ()) {
            return "";
        } else {
            return getElementText (error_message);
        }
    }
}