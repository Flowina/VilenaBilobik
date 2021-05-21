package ru.training.at.hw5.steps.cucumber;

import ru.training.at.hw5.pages.DifferentElementsPage;
import ru.training.at.hw5.steps.DifferentElementsPageSteps;

public class DifferentElementsPageCucumberSteps extends CommonCucumberSteps {
    private final DifferentElementsPage page;
    private DifferentElementsPageSteps pageSteps;

    public DifferentElementsPageCucumberSteps() {
        page = new DifferentElementsPage(driver);
        pageSteps = new DifferentElementsPageSteps(page, assertion);
    }
}
