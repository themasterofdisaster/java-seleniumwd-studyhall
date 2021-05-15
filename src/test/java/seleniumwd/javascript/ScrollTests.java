package seleniumwd.javascript;

import seleniumwd.base.BaseTests;
import org.testng.annotations.Test;

public class ScrollTests extends BaseTests {

    /************************************************************
     NOTE: We did not add assertions to these tests in the video
     ************************************************************/

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
