/*
    Context Click Tests

        Do a context click (right click) on the context menu area on the page below. This will trigger a JavaScript
        alert. Assert we get the correct text in that alert.

        Test page: https://the-internet.herokuapp.com/context_menu
*/
package seleniumwd.ElementsTests;

import seleniumwd.base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextClickTests extends BaseTests {

    @Test
    public void testContextClick(){
        ContextMenuPage contextMenuPage = homePage.clickContextMenuPage();
        contextMenuPage.contextClickOnHotSpot();

        assertEquals(contextMenuPage.alert_getText(),"You selected a context menu", "Alert text does not match the expected");

    }

}
