/*
    TestNG Assertions

        Assertions are used to verify a condition, to check if the test passes or fails.

        There are many assertions for TestNG but most of them are overloaded versions of the following methods:

        assertTrue - verifies a condition is true
        assertFalse - verifies a condition is false
        assertSame - verifies that two objects refer to the same object
        assertNotSame - verifies that two objects do not refer to the same object
        assertNotNull - verifies that an object is not null
        assertEquals - verifies that two objects are equal

        TestNG assertions in general have the same three parameters: actual result, expected result, and a String.

        TestNG assert class: org.testng.Assert
        https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/Assert.html

        TestNG JUnit assert class: org.testng.AssertJUnit
        https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/AssertJUnit.html

        Source: https://testautomationu.applitools.com/introduction-to-testng

 */

package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.testautomationu.utility.Highlighter;

public class AssertionsIntro {

    SoftAssert softassert = new SoftAssert();
    WebDriver driver;

    @BeforeClass
    public void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\max\\Downloads\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("1. Open Chrome & Application");
    }

    @Test
    public void signIn ()
    {
        WebElement textUsername = driver.findElement(By.id("txtUsername"));
        //Highlighter.highlightElement(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.id("txtPassword"));
        //Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
        //Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("2. Sign In");
    }

    //Test with Hard Asserts
    //Hard asserts stop execution after an assert fails. In the example below, if the assert1 fails, the asserts2 and 3
    //will not be executed. Then it will move on to run the next annotation.
    @Test
    public void testHomePageVerificationHA ()
    {
        //These are hard asserts. If this assert fails, none of the following steps will be executed.
        Assert.assertEquals(true, true, "The Welcome Link Is Not Correct On The Home Page");
        System.out.println("3. Verify Welcome Link");

        Assert.assertFalse(false, "The Admin Tab Is Not Displayed On The Home Page");
        System.out.println("4. Verify Admin Tab");

        Assert.assertTrue(true, "The Dashboard Is Not Correct On The Home Page");
        System.out.println("5. Verify Dashboard");

    }

    //Test with Soft Asserts
    //Soft asserts do not fail the test right away. The test steps will continue to execute. At the end, when assertAll()
    //is executed, then the program will evaluate which steps failed and report back. It will return all the failed
    //steps along with the assert error messages.
    @Test
    public void testHomePageVerificationSA ()
    {
        softassert.assertEquals(true, false, "The Welcome Link Is Not Correct On The Home Page");
        System.out.println("3. Verify Welcome Link");

        softassert.assertFalse(false, "The Admin Tab Is Not Displayed On The Home Page");
        System.out.println("4. Verify Admin Tab");

        softassert.assertTrue(false, "The Dashboard Is Not Correct On The Home Page");
        System.out.println("5. Verify Dashboard");

        softassert.assertAll();
    }

    @Test
    public void userSearch ()
    {
        WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        //Highlighter.highlightElement(driver, menuAdmin);
        menuAdmin.click();

        WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
        //Highlighter.highlightElement(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        //Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("6. Search For User");
    }

    @Test
    public void userSignOut ()
    {
        WebElement linkWelcome = driver.findElement(By.id("welcome"));
        //Highlighter.highlightElement(driver, linkWelcome);
        linkWelcome.click();

        WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
        //Highlighter.highlightElement(driver, linkLogout);
        linkLogout.click();

        System.out.println("7. Sign Out");
    }

    @AfterClass
    public void tearDown ()
    {
        System.out.println("8. Close Chrome & Application");
        driver.quit();
    }
}