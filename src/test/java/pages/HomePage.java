package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public String homepageURL = "https://www.automationexercise.com";
    public By login_signup_button = By.xpath ("//a[normalize-space()='Signup / Login']");
    public By products_list = By.xpath ("//a[@href='/products']");
    public By cart_list = By.xpath ("//a[normalize-space()='Cart']");
    public By test_cases = By.xpath ("//a[normalize-space()='Test Cases']");
    public By api_testing = By.xpath ("//a[normalize-space()='API Testing']");
    public By video_tutorials = By.xpath ("//a[normalize-space()='Video Tutorials']");
    public By contact_us = By.xpath ("//a[normalize-space()='Contact us']");
    public By logout_button = By.xpath ("//a[normalize-space()='Logout']");

    public void loadHomePage () {
        loadAWebPage (homepageURL);
    }
}