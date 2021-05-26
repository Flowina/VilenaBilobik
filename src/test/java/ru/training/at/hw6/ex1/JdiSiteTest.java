package ru.training.at.hw6.ex1;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw6.JdiTestingSite;
import ru.training.at.hw6.entities.MetalsAndColorsDataItem;
import ru.training.at.hw6.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JdiSiteTest {
    private final String jsonPath = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        WebDriverUtils.killAllSeleniumDrivers();
        PageFactory.initSite(JdiTestingSite.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        softAssert = null;
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @DataProvider
    public Object[][] data() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, MetalsAndColorsDataItem>> typeRef
                = new TypeReference<HashMap<String, MetalsAndColorsDataItem>>() {};
        HashMap<String, MetalsAndColorsDataItem> map = objectMapper
                .readValue(new File(jsonPath), typeRef);
        Object[][] result = new Object[map.size()][1];
        int i = 0;
        for (Object item : map.values()) {
            result[i][0] = item;
            i++;
        }
        return result;
    }

    @Test(dataProvider = "data")
    public void test(MetalsAndColorsDataItem data) {
        JdiTestingSite.open();

        JdiTestingSite.login((User.Roman));

        JdiTestingSite.mainPage
                .userNameLabel.is().text(User.Roman.getFullName());

        JdiTestingSite.openMetalsAndColorsPage();

        JdiTestingSite.metalsAndColorsPage
                .fillMetalsAndColorsForm(data);

        JdiTestingSite.metalsAndColorsPage
                .submitMetalAndColorForm();

        assertResults(
                JdiTestingSite.metalsAndColorsPage.getResultLines(),
                data.getExpectedResultLines()
        );

        JdiTestingSite.logout();
    }

    private void assertResults(List<String> actual, List<String> expected) {
        softAssert.assertEquals(actual.size(), expected.size(), "Result has wrong lines number");
        for (int i = 0; i < Math.min(actual.size(), expected.size()); i++) {
            softAssert.assertEquals(actual.get(i), expected.get(i));
        }
    }
}
