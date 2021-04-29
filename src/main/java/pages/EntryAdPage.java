package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.xml.stream.events.EntityReference;

public class EntryAdPage {

    private WebDriver driver;
    private By modal = By.id("modal");
    private By modalTitle = By.cssSelector("#modal h3");

    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }

    public String getModalTitle(){
        return driver.findElement(modalTitle).getText();
    }

   // public void clickCloseLink
}
