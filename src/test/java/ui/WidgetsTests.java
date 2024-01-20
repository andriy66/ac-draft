package ui;

import actions.MainPageActions;
import actions.components.SliderActions;
import actions.WidgetsPageActions;
import base.LocalWebDriver;
import com.codeborne.selenide.Selenide;
import components.Cards;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsTests extends BaseTest {
    MainPageActions mainPageActions = new MainPageActions();
    WidgetsPageActions widgetsPageActions = new WidgetsPageActions();
    SliderActions sliderActions = new SliderActions();

    @BeforeMethod
    void setUp() {
        LocalWebDriver.createLocalDriver();
    }

    @AfterTest()
    void close() {
        Selenide.webdriver().driver().getWebDriver().close();
    }
    @Test
    void canSubmitFormWithValidData () {
        mainPageActions.chooseCard(Cards.WIDGETS);
        widgetsPageActions.chooseTab("Slider");
        sliderActions.moveToSliderPercentage(53);
        Assert.assertEquals(sliderActions.getSliderValue(), 53);
    }

}
