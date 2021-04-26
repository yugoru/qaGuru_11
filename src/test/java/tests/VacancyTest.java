package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class VacancyTest {

    @Test
    @DisplayName("Проверяем ссылку на вакансии")
    @Owner("Yulia Gorshkova")
    @Tag("smoke")
    public void searchIssue() {
        step("Открываем главную страницу", () -> open("https://soft-machine.ru/"));
        step("Прокручиваем до появления кнопки 'Присоединяйтесь', кликаем кнопку", () -> {
            $(".join__content").scrollTo();
            $(".join__button").click();
        });
        step("Перключаемся в окно НН, проверяем что это страница Софтмашины", () -> {
            switchTo().window(1);
            $(".company-header .company-header-title-name").shouldHave(text("ООО Софтмашина"));
            WebDriverRunner.closeWindow();
            switchTo().window(0);
        });
    }

}
