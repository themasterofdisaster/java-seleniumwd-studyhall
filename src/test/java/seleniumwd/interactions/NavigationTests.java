package seleniumwd.interactions;

import org.testng.annotations.Test;
import seleniumwd.base.BaseTests;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homePage.clickContextMenuPage();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://duckduckgo.com/");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindowsLink().clickClickHereLink();
        getWindowManager().switchToTab("New Window");
    }
}
