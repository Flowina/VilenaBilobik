package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.testng.asserts.Assertion;
import ru.training.at.hw4.pages.DifferentElementsPage;

public class DifferentElementsPageSteps extends CommonPageSteps {
    private final DifferentElementsPage page;

    public DifferentElementsPageSteps(DifferentElementsPage page, Assertion assertion) {
        super(page, assertion);
        this.page = page;
    }

    @Step("Select checkboxes")
    public void selectCheckboxes(String... names) {
        page.selectCheckboxes(names);
    }

    @Step("Select metals")
    public void selectRadio(String... names) {
        page.selectRadio(names);
    }

    @Step("Select dropdown")
    public void selectDropdown(String... names) {
        page.selectInDropdown(names);
    }

    @Step("Assert logs")
    public void assertLogs(String... names) {
        final String checkboxLogTemplate = "%s: condition changed to true";
        final String radioLogTemplate = "metal: value changed to %s";
        final String dropdownLogTemplate = "Colors: value changed to %s";

        for (String name : names) {
            assertion.assertTrue(
                    page.isLogContainsString(String.format(checkboxLogTemplate, name))
                            || page.isLogContainsString(String.format(radioLogTemplate, name))
                            || page.isLogContainsString(String.format(dropdownLogTemplate, name)),
                    String.format("The log does not contain '%s'", name));
        }
    }

}
