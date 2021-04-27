package tests;

import helpers.TestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FirstPageTest extends TestBase {

    @Test
    @DisplayName("Проверяем первую страницу")
    @Owner("Yulia Gorshkova")
    @Tag("smoke")
    public void firstPageTest() {
        step("Открываем главную страницу", () -> open("https://soft-machine.ru/"));
        step("Проверяем наличие логотипа", () -> {
            $("img[alt='Софтмашина']").shouldBe(visible);
        });
        step("Проверяем верхнее меню", () -> {
            $$(".menu__item").findBy(text("Контакты")).shouldBe(visible);
            $$(".menu__item").findBy(text("Вакансии")).shouldBe(visible);
            $$(".menu__item").findBy(text("Ценности")).shouldBe(visible);
            $$(".menu__item").findBy(text("Стек технологий")).shouldBe(visible);
            $$(".menu__item").findBy(text("Проекты")).shouldBe(visible);
            $$(".menu__item").findBy(text("О нас")).shouldBe(visible);
        });
        step("Проверяем заголовок", () -> {
            $(".first__title").shouldHave(text("Занимаемся любимым делом"));
        });
        step("Проверяем заголовок окна", () -> {
            $("title").shouldHave(attribute("text", "Софтмашина"));
        });
    }

}
