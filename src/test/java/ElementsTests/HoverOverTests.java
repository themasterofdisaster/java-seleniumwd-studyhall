package ElementsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.*;

public class HoverOverTests extends BaseTests {

    @Test
    public void testHoverOverUser1(){
        HoversPage hoversPage = homePage.clickHoversLink();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getFigureName(),"name: user1", "Figure name is incorrect");
        assertEquals(caption.getFigureLinkText(), "View profile", "Figure link text is incorrect");
        assertTrue(caption.getFigureLink().endsWith("/users/1"), "Link incorrect");

    }
}
