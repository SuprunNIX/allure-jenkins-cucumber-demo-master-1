package by.peshkur.allure.steps;

import by.peshkur.allure.pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class Hooks {

    @Before
    public void openUrl() {
        open("https://grinfer.com/");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public  byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @After
    public void af0(Scenario scenario) throws IllegalMonitorStateException {
        scenario.log("After Hook");
        if(scenario.isFailed()) {
            Allure.addAttachment("Any Name", new ByteArrayInputStream(((TakesScreenshot)webdriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
