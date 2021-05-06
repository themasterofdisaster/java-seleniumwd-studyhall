package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

        /* EXPLICIT WAIT */
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public void clickStartButtonFluentWait(){
        driver.findElement(startButton).click();

        /* FLUENT WAIT */
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(
                driver.findElement(loadingIndicator)));
    }

    public String getLoadedTest(){
        return  driver.findElement(loadedText).getText();
    }
}
