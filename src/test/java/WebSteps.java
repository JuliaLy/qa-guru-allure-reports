import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий")
    public void searchRepository() {
        $(".search-input").click();
        $("#query-builder-test").setValue("JuliaLy/qa-guru-allure-reports").pressEnter();
    }

    @Step("Открываем репозиторий")
    public void openRepository() {
        $(By.linkText("JuliaLy/qa-guru-allure-reports")).click();
    }

    @Step("Проверяем что там есть issue с названием TestIssue")
    public void checkIssue() {
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text("TestIssue"), visible);
    }
}
