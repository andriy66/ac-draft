package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WidgetsPage implements BasePage {
    public final SelenideElement sliderTab(String tab) { return $x(String.format("//span[text()='%s']", tab));}
}
