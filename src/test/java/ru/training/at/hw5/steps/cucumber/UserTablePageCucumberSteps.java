package ru.training.at.hw5.steps.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import ru.training.at.hw5.pages.UserTablePage;

import java.util.List;

public class UserTablePageCucumberSteps extends CommonCucumberSteps {
    private final UserTablePage page;

    public UserTablePageCucumberSteps() {
        page = new UserTablePage(driver);
    }

    @When("I select 'vip' checkbox for {string}")
    @Step("I select 'vip' checkbox for {0}")
    public void selectVipCheckboxFor(String userName) {
        page.setVip(userName);
    }

    @Then("{int} log row has {string} text in log section")
    @Step("{0} log row has {1} text in log section")
    public void logRowHasTextInLogSection(int lineNumber, String text) {
        String log = page.getLogText(lineNumber - 1);
        assertion.assertEquals(log, text, "Log contains wrong value");
    }

    @Then("{string} page should be opened")
    @Step("{0} page should be opened")
    public void pageShouldBeOpened(String pageTitle) {
        assertion.assertEquals(page.getTitle(), pageTitle, "Wrong page title");
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    @Step("{0} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertRoleDropdownsCount(int count) {
        int result = page.getRoleDropdownsCount();
        assertion.assertEquals(result, count, "Wrong number of role dropdowns");
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    @Step("{0} Usernames should be displayed on Users Table on User Table Page")
    public void assertUserNamesCount(int count) {
        int result = page.getUserNamesCount();
        assertion.assertEquals(result, count, "Wrong number of user names");
    }

    @Then("{int} Description texts under images "
            + "should be displayed on Users Table on User Table Page")
    @Step("{0} Description texts under images "
            + "should be displayed on Users Table on User Table Page")
    public void assertDescriptionsCount(int count) {
        int result = page.getDescriptionsCount();
        assertion.assertEquals(result, count, "Wrong number of descriptions");
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    @Step("{0} checkboxes should be displayed on Users Table on User Table Page")
    public void assertVipCheckboxesCount(int count) {
        int result = page.getVipCheckboxesCount();
        assertion.assertEquals(result, count, "Wrong number of vip checkboxes");
    }

    @Then("User table should contain following values:")
    @Step("Assert User table")
    public void assertUsers(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        List<UserTablePage.UserTableRow> userRows = page.getUserTable();
        for (int i = 1; i < rows.size(); i++) {
            List<String> columns = rows.get(i);
            assertion.assertEquals(columns.get(0), userRows.get(0).number,
                    "User number is wrong");
            assertion.assertEquals(columns.get(1), userRows.get(0).userName,
                    "User name is wrong");
            assertion.assertEquals(columns.get(2), userRows.get(0).description,
                    "User description is wrong");
        }
    }

    @Then("droplist should contain values in column Type for user {string}")
    @Step("droplist should contain values in column Type for user {0}")
    public void assertUserRoleDropdownValues(String userName, DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        List<String> userRoles = page.getRolesForUser(userName);
        assertion.assertEquals(userRoles.size(), rows.size(),
                String.format("The user '%s' has wrong roles", userName));

        for (int i = 1; i < rows.size(); i++) {
            assertion.assertTrue(userRoles.contains(rows.get(i).get(0)),
                    String.format("The user '%s' does not have '%s' has wrong roles",
                        userName, rows.get(i).get(0)));
        }
    }
}
