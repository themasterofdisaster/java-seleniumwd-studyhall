package seleniumwd.ElementsTests;

import seleniumwd.base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.*;

public class SendKeysTests extends BaseTests {

    private KeyPressesPage keyPressesPage;
    private String text = "A";

    @Test
    public void testAKey(){

        keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterText(text);
        assertEquals(keyPressesPage.getResult(), "You entered: "+text, "Result text is incorrect");
    }

    @Test
    public void testBackspace(){
        keyPressesPage.enterText(text + Keys.BACK_SPACE);
        assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE", "Result text is incorrect");
    }

    @Test
    public void testPi(){
        keyPressesPage.enterPi();
        assertEquals(keyPressesPage.getResult(), "You entered: P", "Result text is incorrect");
    }

}
