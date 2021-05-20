package ru.training.at.hw5.steps.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.MainPage;
import ru.training.at.hw5.pages.UserTablePage;
import ru.training.at.hw5.steps.MainPageSteps;

import static ru.training.at.hw5.context.TestContext.ASSERTION;
import static ru.training.at.hw5.context.TestContext.WEB_DRIVER;

public class CucumberSteps {
    private final MainPage mainPage;
    private final UserTablePage userTablePage;
    private final Assertion assertion;
    private MainPageSteps mainPageSteps;

    public CucumberSteps() {
        WebDriver driver = TestContext.getInstance().getTestObject(WEB_DRIVER);
        assertion = TestContext.getInstance().getTestObject(ASSERTION);
        mainPage = new MainPage(driver);
        mainPageSteps = new MainPageSteps(mainPage, assertion);

        userTablePage = new UserTablePage(driver);
    }

    @Given("I login as user {string} with password {string}")
    public void logIn(String userName, String password) {
        mainPage.logiIn(userName, password);
    }

    @Given("I click on {string} button in Service dropdown")
    public void navigateToDifferentElementsPage(String name) {
        mainPage.clickOnMenuServiceItem(name);
    }

    @Given("I click on {string} button in Header")
    public void clickOnHeaderMenu(String menuName) {
        mainPage.clickOnHeaderMenu(menuName);
    }

    @Given("I open JDI GitHub site")
    public void openPage() {
        mainPage.openPage();
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxFor(String userName) {
        userTablePage.setVip(userName);
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int lineNumber, String text) {
        String log = userTablePage.getLogText(lineNumber - 1);
        assertion.assertEquals(log, text, "Log contains wrong value");
    }

    @Given("I open Different Elements Page")
    public void openDifferentElementsPage() {
        mainPageSteps.navigateToDifferentElementsPage();
    }
}
