/*
    WAITS

        Implicit Wait

            The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time before it
            throws a "No Such Element Exception". This indicates that any time WebDriver needs to interact with an element,
            then it should poll the website for up to 30 seconds until it finds that element.

            The default setting is 0. Once we set the time, the web driver will wait for the element for that time
            before throwing an exception.

            You can see this applied in BaseTests.java in the @BeforeClass, called SetUp (it is commented out). It is
            set up as follows:

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Explicit Wait

            The Explicit Wait in Selenium is used to tell the Web Driver to wait for certain conditions (Expected Conditions)
            or maximum time exceeded before throwing "ElementNotVisibleException" exception. It is an intelligent kind
            of wait, but it can be applied only for specified elements. It gives better options than implicit wait as it
            waits for dynamically loaded Ajax elements. When we use explicit waits, we use them only when we need to.

        Fluent Wait

            The Fluent Wait in Selenium is used to define maximum time for the web driver to wait for a condition, as
            well as the frequency with which we want to check the condition before throwing an "ElementNotVisibleException"
            exception. It checks for the web element at regular intervals until the object is found or timeout happens.

            Frequency: Setting up a repeat cycle with the time frame to verify/check the condition at the regular interval of time

 */

package seleniumwd.elementstests;

import org.testng.annotations.Test;
import pages.DynamicLoadingHiddenElementPage;
import seleniumwd.base.BaseTests;

import static org.testng.Assert.*;

public class WaitTests extends BaseTests {

    @Test
    public void explicitWaitTest(){
        DynamicLoadingHiddenElementPage loadingPage = homePage.goToDynamicLoadingHiddenElementPage();
        loadingPage.clickStartButtonExplicitWait(); // this method implements an explicit wait.
        assertEquals(loadingPage.getLoadedTest(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void fluentWaitTest(){
        DynamicLoadingHiddenElementPage loadingPage = homePage.goToDynamicLoadingHiddenElementPage();
        loadingPage.clickStartButtonFluentWait(); // this method implements a fluent wait.
        assertEquals(loadingPage.getLoadedTest(), "Hello World!", "Loaded text is incorrect");
    }

}
