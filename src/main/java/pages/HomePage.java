    package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink(){
        clickLinkByText("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDownLink(){
        clickLinkByText("Dropdown");
        return new DropdownPage(driver);
    }

    private void clickLinkByText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}