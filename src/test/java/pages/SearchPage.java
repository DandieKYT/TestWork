package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class SearchPage {
    private SelenideElement
            login = $x("//*[@name='login']"),
            password = $x("//*[@name='password']"),
            location = $x("//*[@name='location']"),
            checkResult = $x("//*[contains(@class, 'HotelBlock_hotelItems__ikHEp')]/div");

    public SearchPage login() {
        step("Введение логина", () -> {
            login.setValue("someMail@mail.ru");
        });
        return this;
    }

    public SearchPage password() {
        step("Введение пароля", () -> {
            password.setValue("passssssword").pressEnter();
            sleep(2000);
        });
        return this;
    }
    public SearchPage location() {
        step("Введение названия города \"Санкт-Петребург\"", () -> {
            location.setValue("Санкт-Петербург").pressEnter();
        });
        return this;
    }
    public SearchPage checkResult() {
        step("Проверка наличия результата", () -> {
            checkResult.shouldBe(Condition.visible);
        });
        return this;
    }

}
