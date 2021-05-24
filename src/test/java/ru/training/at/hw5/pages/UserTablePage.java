package ru.training.at.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class UserTablePage extends JdiTestingPage {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/user-table.html";

    @FindBy(css = "#user-table tbody tr")
    private List<WebElement> userRows;

    @FindBy(css = ".panel-body-list.logs li")
    private List<WebElement> logRows;

    @FindBy(css = "#user-table select")
    private List<WebElement> roleDropdowns;

    @FindBy(xpath = "//table[@id='user-table']//tbody/tr/td[position()=1]")
    private List<WebElement> userNumbers;

    @FindBy(xpath = "//table[@id='user-table']//tbody/tr/td[position()=3]/a")
    private List<WebElement> userNames;

    @FindBy(className = "user-descr")
    private List<WebElement> userDescriptions;

    @FindBy(css = "#user-table [type='checkbox']")
    private List<WebElement> vipCheckboxes;

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

    public int getRoleDropdownsCount() {
        return roleDropdowns.size();
    }

    public int getUserNamesCount() {
        return userNames.size();
    }

    public int getDescriptionsCount() {
        return userDescriptions.size();
    }

    public int getVipCheckboxesCount() {
        return vipCheckboxes.size();
    }

    public List<UserTableRow> getUserTable() {
        List<UserTableRow> result = new LinkedList<>();
        for (int i = 0; i < userRows.size(); i++) {
            result.add(new UserTableRow(
                userNumbers.get(i).getText(),
                userNames.get(i).getText(),
                userDescriptions.get(i).getText()
            ));
        }
        return result;
    }

    public List<String> getRolesForUser(String userName) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).getText().equals(userName)) {
                List<WebElement> roles = userRows.get(i).findElements(By.cssSelector("option"));
                for (WebElement role : roles) {
                    result.add(role.getText());
                }
                break;
            }
        }
        return result;
    }

    public class UserTableRow {
        public String number;
        public String userName;
        public String description;

        public UserTableRow(String number, String userName, String description) {
            this.number = number;
            this.userName = userName;
            this.description = description;
        }
    }
}
