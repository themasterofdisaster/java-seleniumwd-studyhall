/*
    Dependency Testing

        So what exactly is dependency testing? Dependency testing is when two or more actions, two or more tasks,
        or two or more functions depend on the order of their methods. We must sign into an application before we can
        test sign out. The sign out test depends on the sign in being successful.

        In a scenario where Dependency Testing is not handled correctly, if the test on which other tests depend on fails,
        then all other tests will be also marked as failed. This is not a correct reflection of the actual test results,
        since the tests don't even get to run.

        In a scenario where Dependency Testing is handled correctly, if the test in which other tests depend on fails,
        then all other tests which had a dependency will be marked as "skipped" and not as failed. This will reflect the
        actual results more accurately since the tests did not get to run.

        TestNG provides these attributes to be used with Dependency Testing:
            - dependsOn
            - groups
            - dependsOnGroups

        Source: https://testautomationu.applitools.com/introduction-to-testng/chapter7.1.html

 */

package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.testautomationu.utility.Highlighter;


public class DependencyTesting {

    WebDriver driver;

    @Test
    public void test1_SetUpChrome ()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\max\\Downloads\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        System.out.println("1. Set Up Chrome");
    }

    //here we add dependsOnMethods attribute to indicate we have a dependency on method test1_SetUpChrome
    @Test (dependsOnMethods = "test1_SetUpChrome")
    public void test2_OpenOrangeHRM ()
    {
        driver.get("https://opensource-demo.orangehrmlive1234.com/");

        Assert.assertEquals(false, true, "Could Not Open OrangeHRM");
        System.out.println("2. Open OrangeHRM");
    }

    @Test (dependsOnMethods = "test2_OpenOrangeHRM")
    public void test3_SignIn ()
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

        System.out.println("3. Sign In");
    }

    @Test (dependsOnMethods = "test3_SignIn")
    public void test4_SearchUser ()
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

        System.out.println("4. Search For User");
    }

    //This test depends on two methods being successful.
    @Test (dependsOnMethods = { "test2_OpenOrangeHRM", "test3_SignIn" } )
    public void test5_SearchEmployee ()
    {
        WebElement menuPIM = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
        //Highlighter.highlightElement(driver, menuPIM);
        menuPIM.click();

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        //Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("5. Search For Employee");
    }

    @Test  (dependsOnMethods = { "test2_OpenOrangeHRM", "test3_SignIn" } )
    public void test6_SearchCandidate ()
    {
        WebElement menuRecruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
        //Highlighter.highlightElement(driver, menuRecruitment);
        menuRecruitment.click();

        WebElement buttonSearch = driver.findElement(By.id("btnSrch"));
        //Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("6. Search For Candidate");
    }

    @Test  (dependsOnMethods = { "test2_OpenOrangeHRM", "test3_SignIn" } )
    public void test7_SignOut ()
    {
        WebElement linkWelcome = driver.findElement(By.id("welcome"));
        //Highlighter.highlightElement(driver, linkWelcome);
        linkWelcome.click();

        WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
        //Highlighter.highlightElement(driver, linkLogout);
        linkLogout.click();

        System.out.println("7. Sign Out");
    }
}