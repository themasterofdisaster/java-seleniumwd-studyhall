package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By inputLocator = By.id("target");
    private By resultLocator = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(inputLocator).sendKeys(text);
    }

    public void enterPi(){
        enterText(Keys.chord(Keys.ALT, "p"));

        //Example to show entering text after chord
        //enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    public String getResult(){
        return driver.findElement(resultLocator).getText();
    }
}
