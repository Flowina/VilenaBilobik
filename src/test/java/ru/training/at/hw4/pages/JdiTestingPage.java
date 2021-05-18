package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class JdiTestingPage {
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameElement;

    protected JdiTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract String getUrl();

    public void openPage() {
        driver.navigate().to(getUrl());
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName() {
        return userNameElement.getText();
    }
}
