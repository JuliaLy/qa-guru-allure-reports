import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaAndAnnotatedStepTests extends TestBase {

    @Test
    public void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий", () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue("JuliaLy/qa-guru-allure-reports").pressEnter();
        });
        step("Открываем репозиторий", () -> {
            $(By.linkText("JuliaLy/qa-guru-allure-reports")).click();
        });
        step("Проверяем что там есть issue с названием TestIssue", () -> {
            $("#issues-tab").click();
            $("#issue_1_link").shouldHave(text("TestIssue"), visible);
        });
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepository();
        steps.openRepository();
        steps.checkIssue();
    }
}

