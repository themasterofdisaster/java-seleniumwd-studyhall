/* #incomplete
    Modal Tests

        Modals do appear in the DOM. You can interact with a modal the same way you would interact with any other part
        of the page.

        Note: When a modal is visible you can only interact with the modal. Yo cannot interact with any other part of
        the page.

        Test page: https://the-internet.herokuapp.com/entry_ad

 */

package seleniumwd.ElementsTests;

import seleniumwd.base.BaseTests;
import org.testng.annotations.Test;
import pages.EntryAdPage;

import static org.testng.Assert.*;

public class ModalTests extends BaseTests {

    //Need to add a wait for this to pass. 
    @Test
    public void testModalOpens(){
        EntryAdPage entryAdPage = homePage.clickEntryAdLink();
        String modalTitle = entryAdPage.getModalTitle();
        assertTrue(modalTitle.equals("THIS IS A MODAL WINDOW"),
                "Modal title incorrect. " + "Expected 'THIS IS A MODAL WINDOW' but received '" + modalTitle + "'");
    }


}
