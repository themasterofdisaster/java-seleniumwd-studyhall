/*
    WAITS

        Implicit Wait

            This indicates that any time WebDriver needs to interact with an element, then it should poll the website
            for up to 30 seconds until it finds that element.
            You can see this applied in BaseTests.java in the @BeforeClass, called SetUp (it is commented out). It is
            set up as follows:

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Explicit Wait

            When we use explicit waits, we use them only when we need to.


 */

package seleniumwd.ElementsTests;

import org.testng.annotations.Test;
import pages.DynamicLoadingHiddenElementPage;
import seleniumwd.base.BaseTests;

import static org.testng.Assert.*;

public class WaitTests extends BaseTests {

    @Test
    public void explicitWaitTest(){
        DynamicLoadingHiddenElementPage loadingPage = homePage.goToDynamicLoadingHiddenElementPage();
        loadingPage.clickStartButtonExplicitWait();
        assertEquals(loadingPage.getLoadedTest(), "Hello World!", "Loaded text is incorrect");
    }
}
