package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Slider implements BaseComponents {
    public final SelenideElement slider = $x("//input[@type='range']");
    public final SelenideElement sliderValue = getElementById("sliderValue");
}
