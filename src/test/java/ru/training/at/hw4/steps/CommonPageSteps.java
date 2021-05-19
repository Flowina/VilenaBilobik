package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.testng.asserts.Assertion;
import ru.training.at.hw4.pages.JdiTestingPage;

public abstract class CommonPageSteps {
    protected final Assertion assertion;
    private final JdiTestingPage page;

    protected CommonPageSteps(JdiTestingPage page, Assertion assertion) {
        this.page = page;
        this.assertion = assertion;
    }

    @Step("Open page")
    public void openPage() {
        page.openPage();
    }

    @Step("Get Browser title")
    public String gerBrowserTitle() {
        return page.getTitle();
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expected) {
        assertion.assertEquals(gerBrowserTitle(), expected, "Wrong page title");
    }

    @Step("Get Username")
    public String getUsername() {
        return page.getUserName();
    }

    @Step("Assert Username")
    public void assertUsername(String expected) {
        assertion.assertEquals(getUsername(), expected, "Wrong User name");
    }
}
