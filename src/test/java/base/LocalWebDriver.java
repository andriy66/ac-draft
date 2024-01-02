package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;

public class LocalWebDriver {
    public static void createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = ConfigReader.BROWSER.getParameterValue();
        Selenide.open(Objects.requireNonNull(ConfigReader.URL.getParameterValue()));
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }
}
