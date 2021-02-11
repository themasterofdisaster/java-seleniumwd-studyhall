/*
    Data Driven Testing - Data Provider

        The @DataProvider annotation returns Java objects which are values to the test method.
        The dataProvider attribute connects the @DataProvider annotation to the test method.

        The dataProviderClass attribute allows us to separate the test method and data provider into different classes.
            If putting the dataProvider in a separate class, make sure to make the data provider class "static"
            ie:      public static Object [] [] logInData () {}

        Source: https://testautomationu.applitools.com/introduction-to-testng
 */

package testng;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;

public class DDTAndDataProvider
{
    WebDriver driver;


    @Test (dataProvider = "login-provider")
    public void logIn (String email, String password, boolean success)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\max\\Downloads\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

        System.out.println("Log In Credentials: " + "\n" +
                "  Email = " + email + "\n" +
                "  Password = " + password + "\n" +
                "  Successful Log In = " + success + "\n" );

        String actualResult = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).getText();
        String expectedResult = "Sign out";
        Assert.assertEquals(actualResult, expectedResult, "The Actual & Expected Results Do Not Match");

        driver.quit();
    }

    //You can give the @DataProvider a name or not. It is optional. If you choose not to use a name, then simply use
    //the class name in @Test's dataProvider attribute.
    @DataProvider (name = "login-provider")
    public Object [] [] logInData ()
    {
        Object [] [] data = new Object [3] [3];

        data [0] [0] = "TestNG@Framework.com";		data [0] [1] = "TestNG1234";		data [0] [2] = true;
        data [1] [0] = "Joe@Doe.com";				data [1] [1] = "DoeDoe34";			data [1] [2] = false;
        data [2] [0] = "Test@AutomationU.com";		data [2] [1] = "TAU1234";			data [2] [2] = true;

        return data;
    }
}