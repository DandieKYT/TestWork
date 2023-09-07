package pages;

import com.codeborne.selenide.Selenide;

import static io.qameta.allure.Allure.step;

public class BasePage {
    public BasePage openPage() {
        step("Открытие сайта", () -> {
            Selenide.open("/");
        });
        return this;
    }
}
