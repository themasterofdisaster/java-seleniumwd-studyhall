package seleniumwd.elementstests;

import seleniumwd.base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSlider(){
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderLink();
        assertEquals(horizontalSliderPage.getSliderRange(), "0", "Slider range is incorrect");

        horizontalSliderPage.moveSlider(8);
        assertEquals(horizontalSliderPage.getSliderRange(), "4", "Slider range is incorrect");

    }
}
