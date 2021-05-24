package ru.training.at.hw5.steps;

import io.qameta.allure.Step;
import org.testng.asserts.Assertion;
import ru.training.at.hw5.pages.MainPage;

public class MainPageSteps extends CommonPageSteps {
    private final MainPage page;

    public MainPageSteps(MainPage page, Assertion assertion) {
        super(page, assertion);
        this.page = page;
    }

    @Step("Log in")
    public void logIn(String userName, String password) {
        page.logiIn(userName, password);
    }

    @Step("Assert header items size")
    public void assertHeaderItemsSize(int size) {
        assertion.assertEquals(page.headerItems().size(), size, "Wrong items count in the header");
    }

    @Step("Assert header items text")
    public void assertHeaderItemsText(String home,
                                      String contactForm,
                                      String service,
                                      String metalColors) {
        assertion.assertEquals(page.getHeaderItem("HOME").getText(), home,
                "The item \"HOME\" does not exist in the header");
        assertion.assertEquals(page.getHeaderItem("CONTACT FORM").getText(), contactForm,
                "The item \"CONTACT FORM\" does not exist in the header");
        assertion.assertEquals(page.getHeaderItem("SERVICE").getText(), service,
                "The item \"SERVICE\" does not exist in the header");
        assertion.assertEquals(page.getHeaderItem("METALS & COLORS").getText(), metalColors,
                "The item \"METALS & COLORS\" does not exist in the header");
    }

    @Step("Assert benefits icons")
    public void assertBenefitsIcons(int size) {
        assertion.assertEquals(page.benefitIcons.size(), 4, "Wrong benefit icons count");
    }

    @Step("Assert benefits icons text")
    public void assertBenefitsIconsText() {
        assertion.assertNotNull(page.benefitTextItem(
                "To include good practices\nand ideas from successful\nEPAM project"));
        assertion.assertNotNull(page.benefitTextItem("To be flexible and\ncustomizable"));
        assertion.assertNotNull(page.benefitTextItem("To be multiplatform"));
        assertion.assertNotNull(page.benefitTextItem("Already have good base"
                + "\n(about 20 internal and\nsome external projects),"
                + "\nwish to get more…"));
    }

    @Step("Assert iframe with “Frame Button” exist")
    public void assertIsFrameWithButtonExists() {
        assertion.assertTrue(page.isFrameWithButtonExists(),
                "The frame with button does not exist");
    }

    @Step("Assert switch to frame with Button")
    public void assertSwitchToFrameWithButton() {
        assertion.assertTrue(page.isFrameWithButtonExists(), "Do not switched");
    }

    @Step("Switch to original window back")
    public void switchBackToWindow() {
        page.switchBack();
    }

    @Step("Assert Left Section Items")
    public void assertLeftSectionItems() {
        assertion.assertEquals(page.sidebarMenuItems().size(), 5);
        assertion.assertNotNull(page.sidebarMenuItem("Home"));
        assertion.assertNotNull(page.sidebarMenuItem("Contact form"));
        assertion.assertNotNull(page.sidebarMenuItem("Service"));
        assertion.assertNotNull(page.sidebarMenuItem("Metals & Colors"));
        assertion.assertNotNull(page.sidebarMenuItem("Elements packs"));
    }

    @Step("Navigate to different Elements Page")
    public void navigateToDifferentElementsPage() {
        page.clickOnMenuServiceItem("Different elements");
    }

    @Step("Navigate to User Table Page")
    public void navigateToUserTablePage() {
        page.clickOnMenuServiceItem("User Table");
    }
}
