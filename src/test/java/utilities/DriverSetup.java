package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {
    private static String browserName = System.getProperty ("browser", "Chrome");

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<> ();

    public static WebDriver getDriver () {
        return WEB_DRIVER_THREAD_LOCAL.get ();
    }

    public static void setDriver (WebDriver driver) {
        DriverSetup.WEB_DRIVER_THREAD_LOCAL.set (driver);
    }

    public WebDriver getBrowser (String browserName) {
        if (browserName.equalsIgnoreCase ("chrome")) {
            return new ChromeDriver ();
        } else if (browserName.equalsIgnoreCase ("firefox")) {
            return new FirefoxDriver ();
        } else if (browserName.equalsIgnoreCase ("edge")) {
            return new EdgeDriver ();
        } else if (browserName.equalsIgnoreCase ("safari")) {
            return new SafariDriver ();
        } else {
            throw new AssertionError ("Unsupported browser: " + browserName);
        }
    }

    @BeforeMethod
    public void setUp () {
        WebDriver driver = getBrowser (browserName);
        driver.manage ().window ().maximize ();
        driver.manage ().deleteAllCookies ();
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (15));
        setDriver (driver);
    }

    @AfterMethod
    public void tearDown () {
        getDriver ().quit ();
    }
}