package ru.training.at.hw5.steps.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.steps.DifferentElementsPageSteps;

public class DifferentElementsPageCucumberSteps extends CommonCucumberSteps {
    private final DifferentElementsPage page;
    private DifferentElementsPageSteps pageSteps;

    public DifferentElementsPageCucumberSteps() {
        page = new DifferentElementsPage(driver);
        pageSteps = new DifferentElementsPageSteps(page, assertion);
    }

    @When("I select checkbox {string}")
    public void selectCheckbox(String name) {
        pageSteps.selectCheckboxes(name);
    }

    @When("I select radio button {string}")
    public void selectRadioButton(String name) {
        pageSteps.selectRadio(name);
    }

    @When("I select {string} color from dropdown menu")
    public void selectColorFromDropdownMenu(String name) {
        pageSteps.selectDropdown(name);
    }

    @Then("Log entry matche to checkbox {string} is displayed")
    public void logEntryMatcheToCheckboxIsDisplayed(String name) {
        pageSteps.assertLogs(name);
    }

    @Then("Log entry match to radio button {string} is displayed")
    public void logEntryMatchToRadioButtonIsDisplayed(String name) {
        pageSteps.assertLogs(name);
    }

    @Then("Log entry match color {string} is displayed")
    public void logEntryMatchColorIsDisplayed(String name) {
        pageSteps.assertLogs(name);
    }
}
