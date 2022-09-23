package by.peshkur.allure.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasicPage {

    public void clickButton(String text) { $(By.xpath("//*[@id='page-root']/div[1]/div[2]/div[2]/ul/a[1]")).click();
    }

    public void clickButtonSpan(String text) {
        $(By.xpath("//span[text()='" + text + "']/..")).click();
    }

    public void contentIsVisible(String text) {
        $(By.xpath("//*[text()='" + text + "']")).shouldBe(Condition.visible);
    }
}
