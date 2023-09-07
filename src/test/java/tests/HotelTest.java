package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class HotelTest extends TestBase {
    @Test
    public void hotelCheck(){
    basePage.openPage();
    searchPage.login();
    searchPage.password();
    searchPage.location();
    searchPage.checkResult();

    }
}
