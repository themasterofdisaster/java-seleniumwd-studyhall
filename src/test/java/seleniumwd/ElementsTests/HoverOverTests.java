package seleniumwd.ElementsTests;

import seleniumwd.base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.*;

public class HoverOverTests extends BaseTests {

    private HoversPage hoversPage;
    private HoversPage.FigureCaption caption;

    @Test
    public void testHoverOverUser1(){
        hoversPage = homePage.clickHoversLink();
        caption = hoversPage.hoverOverFigure(1);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getFigureName(),"name: user1", "Figure name is incorrect");
        assertEquals(caption.getFigureLinkText(), "View profile", "Figure link text is incorrect");
        assertTrue(caption.getFigureLink().endsWith("/users/1"), "Link incorrect");

    }

    @Test
    public void testHoverOverUser2(){
        caption = hoversPage.hoverOverFigure(2);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getFigureName(),"name: user2", "Figure name is incorrect");
        assertEquals(caption.getFigureLinkText(), "View profile", "Figure link text is incorrect");
        assertTrue(caption.getFigureLink().endsWith("/users/2"), "Link incorrect");

    }
}
