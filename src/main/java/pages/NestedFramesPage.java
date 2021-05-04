package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String topFrameName = "frame-top";
    private String leftFrameName = "frame-left";
    private String bottomFrameName = "frame-bottom";
    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void switchToLeftFrame(){
        switchToFrame(leftFrameName);
    }

    public String getBottomFrameText(){
        switchToFrame(bottomFrameName);
        String text = getFrameText();
        switchToParentFrame();
        return text;
    }

    public String getLeftFrameText(){
        switchToFrame(topFrameName);
        switchToFrame(leftFrameName);
        String text = getFrameText();
        switchToParentFrame();
        switchToParentFrame();
        return text;
    }

    private String getFrameText(){
        return driver.findElement(body).getText();
    }

    private void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }

    private void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

}
