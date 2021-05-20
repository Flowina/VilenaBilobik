package ru.training.at.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends JdiTestingPage {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(css = ".uui-profile-menu")
    private WebElement profileMenu;

    @FindBy(id = "login-form")
    private WebElement loginForm;

    @FindBy(css = "#login-form #name")
    private WebElement userName;

    @FindBy(css = "#login-form #password")
    private WebElement password;

    @FindBy(css = "#login-form #login-button")
    private WebElement loginButton;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> headerItemElements;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(css = ".sidebar-menu.left > li")
    private List<WebElement> sidebarMenuItems;

    @FindBy(xpath = "//span[contains(@class, 'icons-benefit')]")
    public List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[contains(@class, 'benefit-txt')]")
    private List<WebElement> benefitTexts;

    @FindBy(linkText = "Service")
    private WebElement menuService;

    @FindBy(linkText = "Different elements")
    private WebElement menuServiceDifferentElements;

    @FindBy(linkText = "User Table")
    private WebElement menuServiceUserTable;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    public void openPage() {
        super.openPage();
    }

    public void logiIn(String userName, String password) {
        profileMenu.click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public List<WebElement> headerItems() {
        return headerItemElements;
    }

    public WebElement getHeaderItem(String name) {
        for (WebElement item : headerItems()) {
            if (item.getText().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean isFrameWithButtonExists() {
        return frame.isDisplayed();
    }

    public void switchToFrameWithButton() {
        driver.switchTo().frame(frame);
    }

    public boolean isButtonExists() {
        return driver.findElement(By.id("frame-button")) != null;
    }

    public void switchBack() {
        driver.switchTo().parentFrame();
    }

    public List<WebElement> sidebarMenuItems() {
        return sidebarMenuItems;
    }

    public WebElement sidebarMenuItem(String name) {
        for (WebElement item : sidebarMenuItems()) {
            if (item.getText().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public WebElement benefitTextItem(String text) {
        for (WebElement item : benefitTexts) {
            if (item.getText().equals(text)) {
                return item;
            }
        }
        return null;
    }

    public void clickOnHeaderMenu(String name) {
        switch (name.toLowerCase()) {
            case "service":
                menuService.click();
                break;
            default:
        }
    }

    public void clickOnMenuServiceItem(String name) {
        String urlFragment = "***";
        switch (name.toLowerCase()) {
            case "different elements":
                menuServiceDifferentElements.click();
                urlFragment = "different-elements.html";
                break;
            case "user table":
                menuServiceUserTable.click();
                urlFragment = "user-table.html";
                break;
            default:
                return;
        }

        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.and(
            ExpectedConditions.urlContains(urlFragment),
            ExpectedConditions.visibilityOfElementLocated(By.className("main-content"))
        ));
    }
}
