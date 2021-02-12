/*
    Cross Browser Testing and the Use of Parameters

        Use the @Paramaters annotation to indicate the name of the parameters you want to call.
        In this case we take the parameters "URL" and "BrowserType" from the file "parametersforcrossbrowsertesting.xml"

        Source:
        https://testautomationu.applitools.com/introduction-to-testng/chapter9.html
 */

package testng;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class CrossBrowserTesting
{
    WebDriver driver;

    @Test
    @Parameters ( {"URL", "BrowserType"} )
    public void verifyTAU (String url, String browserType)
    {
        if (browserType.equalsIgnoreCase("Internet Explorer"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\max\\Downloads\\Drivers\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
            driver = new InternetExplorerDriver ();
        }
        else if (browserType.equalsIgnoreCase("Firefox"))
        {
            driver = new FirefoxDriver ();
        }
        else if (browserType.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\max\\Downloads\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver ();
        }

        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("\n" + "Open " + browserType);
        System.out.println("   " +  driver.getTitle());
        System.out.println("   " +  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div[1]/section[1]/p[1]")).getText());
        System.out.println("Close " + browserType + "\n");

        driver.quit();
    }
}
