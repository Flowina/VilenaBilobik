package ru.training.at.hw5.steps;

import org.testng.asserts.Assertion;
import ru.training.at.hw5.pages.UserTablePage;

public class UserTablePageSteps extends CommonPageSteps {
    private final UserTablePage page;

    protected UserTablePageSteps(UserTablePage page, Assertion assertion) {
        super(page, assertion);
        this.page = page;
    }

    //@When("I select {string} checkbox for {string}")
    public void selectVipCheckboxFor(String checkbox, String userName) {
    }

    //@Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int count, String text) {
    }
}
