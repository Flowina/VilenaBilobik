package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/resources/hw5"},
    glue = {"ru.training.at.hw5"},
    tags = "not @Skip"
)
public class RunAllCucumberTests extends AbstractTestNGCucumberTests {
}
