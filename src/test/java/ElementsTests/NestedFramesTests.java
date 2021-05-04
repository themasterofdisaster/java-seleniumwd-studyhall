package ElementsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NestedFramesPage;

import static org.testng.Assert.*;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testNestedFrames(){
        NestedFramesPage nestedFramesPage = homePage.goToNestedFramesPage();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Left frame text does not match the expected");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Left frame text does not match the expected");
    }
}
