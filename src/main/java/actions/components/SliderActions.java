package actions.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.Slider;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {
    private Slider slider = new Slider();

    public void moveToSliderPercentage(int positionPercentage) {
        int sliderWidth = slider.slider.getSize().width;
        int xOffset = sliderWidth / 100;
        while (getCurrentSliderPercentage(slider.slider) != positionPercentage) {
            Actions actions = new Actions(Selenide.webdriver().driver().getWebDriver());
            //setup the xoffset
            actions.dragAndDropBy(slider.slider, xOffset, 0);
            actions.perform();
            xOffset++;
        }
    }
    public int getSliderValue() {
        return getCurrentSliderPercentage(slider.sliderValue);
    }

    private int getCurrentSliderPercentage(SelenideElement slider) {
        String script = "return arguments[0].value";
        String sliderValue = Selenide.executeJavaScript(script, slider);
        return Integer.parseInt(sliderValue);
    }
}
