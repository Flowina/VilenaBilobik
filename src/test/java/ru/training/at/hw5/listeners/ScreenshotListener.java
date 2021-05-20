package ru.training.at.hw5.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure.enter " + result.getName());
        Object driver = result.getTestContext().getAttribute("driver");

        if (driver != null) {
            System.out.println("Making screenshot...");
            makeScreenshot((TakesScreenshot) driver);
        }

        System.out.println("onTestFailure.exit");
    }

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot(TakesScreenshot driver) {
        byte[] array = {1};
        try {
            return driver.getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }
}
