package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public interface BasePage {
    default SelenideElement getElementByText(String text) {
        return $x(String.format("//*[text() = '%s']", text));
    }

    default SelenideElement getElementById(String id) {
        return $("#" + id);
    }
}
