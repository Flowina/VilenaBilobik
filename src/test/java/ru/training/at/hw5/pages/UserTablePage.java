package ru.training.at.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTablePage extends JdiTestingPage {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/user-table.html";

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> userRows;

    @FindBy(css = ".panel-body-list.logs li")
    private List<WebElement> logRows;

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected String getUrl() {
        return null;
    }

    public void setVip(String userName) {
        for (WebElement row : userRows) {
            List<WebElement> userLinks = row.findElements(By.linkText(userName));
            if (userLinks.size() > 0) {
                row.findElement(By.xpath("//label[text()='Vip']")).click();
                break;
            }
        }
    }

    public String getLogText(int lineNumber) {
        return (logRows != null && logRows.size() > lineNumber)
            ? logRows.get(lineNumber).getText()
            : null;
    }
}
