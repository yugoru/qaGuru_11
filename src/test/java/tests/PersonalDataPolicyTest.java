package tests;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.FormatFiles.getPdf;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonalDataPolicyTest {

    @Test
    @DisplayName("Проверяем файл с политикой персональных данных")
    @Owner("Yulia Gorshkova")
    @Tag("smoke")
    public void searchIssue() throws IOException {
        step("Открываем главную страницу", () -> open("https://soft-machine.ru/"));
        step("Прокручиваем до футера сайта", () -> {
            $(".foot").scrollTo();
        });
        step("Скачиваем файл, проверяем его содержимое", () -> {
        File download = $(".foot__item a").download();
        String file = download.getAbsolutePath();
        PDF pdf = getPdf(file);
            assertThat(pdf, PDF.containsText("ПОЛИТИКА В ОТНОШЕНИИ ПЕРСОНАЛЬНЫХ ДАННЫХ"));
        });
    }

}
