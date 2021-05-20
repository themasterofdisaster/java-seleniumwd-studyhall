package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public ContextMenuPage clickContextMenuPage(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public DropdownPage clickDropDownLink(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public EntryAdPage clickEntryAdLink(){
        clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }

    public FileUploadPage clickFileUploadLink(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public FormAuthenticationPage clickFormAuthenticationLink(){
        clickLink("Form Authentication");
        return new FormAuthenticationPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderLink(){
         clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public HoversPage clickHoversLink(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public AlertsPage clickJavaScriptAlertsLink(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public KeyPressesPage clickKeyPressesLink(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsLink(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditorLink(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public NestedFramesPage goToNestedFramesPage(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        return new NestedFramesPage(driver);
    }

    public DynamicLoadHiddenElementPage goToDynamicLoadingHiddenElementPage(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        return new DynamicLoadHiddenElementPage(driver);
    }

    public DynamicLoadRenderedElementPage goToDynamicLoadRenderedElementPage(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        return new DynamicLoadRenderedElementPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}