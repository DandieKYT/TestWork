package tests;

import com.codeborne.selenide.Configuration;
import help.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BasePage;
import pages.SearchPage;

import java.util.Map;


public class TestBase extends Attachment {
    BasePage basePage = new BasePage();
    SearchPage searchPage = new SearchPage();
    Attachment attachment = new Attachment();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://anatoliinovikov.ru/projects/hotels";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void attachemts() {
        attachment.browserLogs();
        attachment.attachScreenshot();
        attachment.pageSource();
        attachment.addVideo();
    }
}

