package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseTinkoff {
    @BeforeEach
    void init() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.tinkoff.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
      //Configuration.holdBrowserOpen = true;
    }
    @AfterEach
    void setApp() {
        Selenide.closeWebDriver();
    }
}
