package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class LocalWebDriver {
    public static void createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = ConfigReader.BROWSER.getParameterValue();
        open(Objects.requireNonNull(ConfigReader.URL.getParameterValue()));
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }
}
