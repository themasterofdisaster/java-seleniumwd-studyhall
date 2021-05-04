package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By contextMenuHotSpotLocator = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void contextClickOnHotSpot(){
        WebElement contextMenuHotSpot = driver.findElement(contextMenuHotSpotLocator);

        Actions actions = new Actions(driver);
        actions.moveToElement(contextMenuHotSpot).contextClick().perform();

    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }


}
