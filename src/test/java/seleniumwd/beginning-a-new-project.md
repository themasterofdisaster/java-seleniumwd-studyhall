## How to Start a New SeleniumWD+TestNG Project

#### Install: 

[Java](https://www.oracle.com/java/technologies/javase-downloads.html)

[IntelliJ](https://www.jetbrains.com/idea/download/#section=mac)

[Chrome Browser](https://www.google.com/chrome/)

[Chrome Driver Executable](http://chromedriver.chromium.org/downloads)

[Maven Repository for Selenium Chrome Driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver/3.141.59)

### To create a new project 

File -> New -> Project...
    Select "Maven" project. 
    Indicate name. 
    
#### Update the pom.xml file: 

    <!-- Let intellij know to compile our code using the appropriate java version. -->
    <properties>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
    </properties>
    
    <!-- Created a dependencies section. -->  
    <dependencies>
        <!-- Include selenium chrome web driver dependency -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>3.141.59</version>
        </dependency>
        
        <!-- Include selenium support dependency. This allows you to interact with dropdown elements -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-support</artifactId>
            <version>3.141.59</version>
        </dependency>

        
        <!-- Include TestNG dependency -->    
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

Go to the "Maven" tab on the right side on IntelliJ Idea. Make sure there's a "Dependencies" folder and make sure 
that Selenium and TestNG are listed under the dependencies. If they are not, click on the "Reimport" button (first button
on the top left of the Maven window).

#### Include the Chrome driver executable in your project. 
Create a new directory on your project, call it "resources" and drag the chrome driver executable into this folder. 

### Sources 

Dependencies: 

[Maven Repository for Selenium Chrome Web Driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver/3.141.59)

[Maven Repository for Selenium Support](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support)

[Maven Repository for TestNG](https://mvnrepository.com/artifact/org.testng/testng/6.14.3)