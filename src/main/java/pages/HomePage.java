package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public FormAuthenticationPage clickFormAuthenticationLink(){
        clickLink("Form Authentication");
        return new FormAuthenticationPage(driver);
    }

    public DropdownPage clickDropDownLink(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHoversLink(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPressesLink(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public AlertsPage clickJavaScriptAlertsLink(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditorLink(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FileUploadPage clickFileUploadLink(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public EntryAdPage clickEntryAdLink(){
        clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}