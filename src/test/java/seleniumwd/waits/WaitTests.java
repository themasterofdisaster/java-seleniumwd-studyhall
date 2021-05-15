/*
    WAITS

        Implicit Wait

            See ImplicitWaitTest.java

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


        Other Waits

            Under driver.Manage.timeouts find:

            pageLoadTimeout
                Allows you to set the amount of time to wait for a page load to complete before it throws an error.

            setScriptTimeout
                Allows you to set the amount of time to wait for asynchronous scripts to finish executing.

 */

package seleniumwd.waits;

import org.testng.annotations.Test;
import pages.DynamicLoadRenderedElementPage;
import pages.DynamicLoadHiddenElementPage;
import seleniumwd.base.BaseTests;

import static org.testng.Assert.*;

public class WaitTests extends BaseTests {

    @Test
    public void explicitWaitTest(){
        DynamicLoadHiddenElementPage loadingPage = homePage.goToDynamicLoadingHiddenElementPage();
        loadingPage.clickStartButtonExplicitWait(); // this method implements an explicit wait.
        assertEquals(loadingPage.getLoadedTest(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void fluentWaitTest(){
        DynamicLoadHiddenElementPage loadingPage = homePage.goToDynamicLoadingHiddenElementPage();
        loadingPage.clickStartButtonFluentWait(); // this method implements a fluent wait.
        assertEquals(loadingPage.getLoadedTest(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void waitUntilElementIsRenderedTest(){
        DynamicLoadRenderedElementPage loadRenderedElementPage = homePage.goToDynamicLoadRenderedElementPage();
        loadRenderedElementPage.clickStartButton();
        assertEquals(loadRenderedElementPage.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }

}
