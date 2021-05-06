package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingHiddenElementPage {

    WebDriver driver;
    By startButton = By.cssSelector("#start button");
    By loadingIndicator = By.id("loading");
    By loadedText = By.id("finish");

    public DynamicLoadingHiddenElementPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButtonExplicitWait(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedTest(){
        return  driver.findElement(loadedText).getText();
    }
}
