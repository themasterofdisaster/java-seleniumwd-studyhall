# Selenium WebElement Locators


### By.id

    private By usernameField = By.id("username");

### By.cssSelector

Find id="login" and get be the button within that locator. 

    private By loginButton = By.cssSelector("#login button");

### By.xpath

    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    
### By.linkText

    By.linkText("linkText");
    
    
### By.className

    private By figureCaptionLocator  = By.className("figcaption");
    
Test the locator in dev tools: 

    .figcaption