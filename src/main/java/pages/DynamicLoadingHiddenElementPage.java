package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingHiddenElementPage {

    WebDriver driver;
    By startButton = By.id("start");

    public DynamicLoadingHiddenElementPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();
    }
}
