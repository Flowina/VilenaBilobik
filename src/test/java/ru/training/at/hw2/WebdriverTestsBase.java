package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class WebdriverTestsBase {
    protected WebDriver webDriver;
    protected WebElement webElement;
    protected SoftAssert softAssert;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod(alwaysRun = true)
    protected void closeWebdriver() {
        softAssert = null;
        // 12 Close Browser
        if (webDriver != null) {
            webDriver.close();
            webDriver = null;
        }
    }

    @BeforeMethod(alwaysRun = true)
    protected void initWebdriver() {
        softAssert = new SoftAssert();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
    }

    protected void openSiteTest() {
        //1 Open test site by URL https://jdi-testing.github.io/jdi-light/index.html
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");

        // 2 Assert Browser title "Home Page"
        softAssert.assertEquals("Home Page", webDriver.getTitle());
    }

    protected void loginTest() {
        // 3 Perform login username: Roman pass: Jdi1234
        webElement = webDriver.findElement(By.cssSelector(".uui-profile-menu"));
        webElement.click();

        WebElement loginForm = webDriver.findElement(By.id("login-form"));
        //find username field
        webElement = loginForm.findElement(By.id("name"));
        webElement.sendKeys("Roman");
        //find password field
        webElement = loginForm.findElement(By.id("password"));
        webElement.sendKeys("Jdi1234");
        //find enter button
        webElement = loginForm.findElement(By.id("login-button"));
        webElement.click();

        // 4 Assert Username is loggined "ROMAN IOVLEV"
        webElement = webDriver.findElement(By.id("user-name"));
        softAssert.assertEquals(webElement.getText(), "ROMAN IOVLEV");
    }
}
