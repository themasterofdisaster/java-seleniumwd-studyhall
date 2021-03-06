package seleniumwd.base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //driver = new ChromeDriver();  //driver with no chrome options
        driver = new ChromeDriver(getChromeOptions());  //driver with chrome options
        driver.get("https://the-internet.herokuapp.com/");
        // Implicit wait:
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        setCookie();
    }

    /*
        Event Listeners
            Selenium offers an interface called WebDriverEventListener , which provides methods that will listen for
            Selenium events and allow you to add additional functionality when those events occur.

            To see "Event Listeners" in action, comment the @BeforeClass above, along with the declaration of WebDriver
            driver. Then uncomment the @BeforeClass below, along with the declaration of EventFiringWebDriver.

            You'd normally have to create a class with implements "WebDriverEventListener" but in this case it's already
            been created. Find it in src/main/java/utils/EventReporter.java

            There's a print statement for every time a click event takes place, you can modify and play with any other
            event in the class.
     */

    //private EventFiringWebDriver driver;

//    @BeforeClass
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
//        driver = new EventFiringWebDriver(new ChromeDriver());
//        driver.register(new EventReporter());
//        driver.get("https://the-internet.herokuapp.com/");
//        homePage = new HomePage(driver);
//        //goHome();
//    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    @BeforeMethod
//    public void goHome(){
//        driver.get("https://the-internet.herokuapp.com/");
//        homePage = new HomePage(driver);
//    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    // Use ChromeOptions to make modifications to the browser which will open to run the automated tests.
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        //Headless mode will run the tests without opening the browser. These typically run a little bit faster.
        //The downside is you don't get to see the actual browser while running the test:
        //options.setHeadless(true);
        return options;
    }

    //Cookie.Builder will allow us to manipulate cookies. You can delete a cookie, all cookies, cookie with a specific name. Etc.
    // The following method will create and set a cookie "tau" with value "123":
    private void setCookie(){

        //Creates the cookie
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();

        //Sets the cookie
        driver.manage().addCookie(cookie);
    }
}