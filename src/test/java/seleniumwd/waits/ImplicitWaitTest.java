/*
    Implicit Wait
        The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time before it
        throws a "No Such Element Exception". This indicates that any time WebDriver needs to interact with an element,
        then it should poll the website for up to 30 seconds until it finds that element.

        The default setting is 0. Once we set the time, the web driver will wait for the element for that time
        before throwing an exception.

        You can see this in BaseTests.java in the @BeforeClass, called setUp (it is commented out).
        It is set up as follows:

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        In this class...
            I attempted to override the @BeforeClass in BaseTests (the setUp method) to have it implement an implicit wait.
            Had to declare a new WebDriver driver and homePage, but upon running the tearDown fails with a
            NullPointerException. I suspect this happens because it is trying to quit the driver within BaseTests()
            which has not been initialized because of the override.
 */

package seleniumwd.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormAuthenticationPage;
import pages.HomePage;
import seleniumwd.base.BaseTests;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ImplicitWaitTest extends BaseTests {

    //Note: Look into best practices for extending BaseTests classes. I feel like declaring a new WebDriver field might
    //not be a good practice. 
    private WebDriver driver;
    protected HomePage homePage;

    @Override @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // Implicit wait:
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest(){
        FormAuthenticationPage formAuthenticationPage = homePage.clickFormAuthenticationLink();

    }

}
