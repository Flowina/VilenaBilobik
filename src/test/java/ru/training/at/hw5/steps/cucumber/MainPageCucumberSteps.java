package ru.training.at.hw5.steps.cucumber;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.pages.MainPage;
import ru.training.at.hw5.steps.MainPageSteps;

public class MainPageCucumberSteps extends CommonCucumberSteps {
    private final MainPage mainPage;
    private MainPageSteps mainPageSteps;

    public MainPageCucumberSteps() {
        mainPage = new MainPage(driver);
        mainPageSteps = new MainPageSteps(mainPage, assertion);
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

    @Given("I open Different Elements Page")
    public void openDifferentElementsPage() {
        mainPageSteps.navigateToDifferentElementsPage();
    }

}
