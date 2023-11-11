import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenerSelenideTests extends TestBase{

    @Test
    public void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("JuliaLy/qa-guru-allure-reports").pressEnter();
        $(By.linkText("JuliaLy/qa-guru-allure-reports")).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text("TestIssue"), visible);
    }
}
