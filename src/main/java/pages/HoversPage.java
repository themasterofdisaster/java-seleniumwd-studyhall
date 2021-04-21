package pages;
/*
    Test Hovering Over an Element.
        Use Selenium Actions
        JavaDoc: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html#Actions-org.openqa.selenium.WebDriver-
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;

    private By figureLocator = By.className("figure");
    private By figureCaptionLocator  = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param index starts at 1
     * @return
     */
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(figureLocator).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(figureCaptionLocator));
    }

    public class FigureCaption{

        private WebElement caption;
        private By figureNameLocator = By.tagName("h5");
        private By figureLinkLocator = By.tagName("a");

        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getFigureName(){
            return caption.findElement(figureNameLocator).getText();
        }

        public String getFigureLink(){
            return caption.findElement(figureLinkLocator).getAttribute("href");
        }

        public String getFigureLinkText(){
            return  caption.findElement(figureLinkLocator).getText();
        }
    }
}
