package ui;

import actions.MainPageActions;
import actions.components.SliderActions;
import actions.WidgetsPageActions;
import components.Cards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends BaseTest {
    MainPageActions mainPageActions = new MainPageActions();
    WidgetsPageActions widgetsPageActions = new WidgetsPageActions();
    SliderActions sliderActions = new SliderActions();

    @Test
    void canSubmitFormWithValidData () {
        mainPageActions.chooseCard(Cards.WIDGETS);
        widgetsPageActions.chooseTab("Slider");
        sliderActions.moveToSliderPercentage(53);
        Assertions.assertEquals(sliderActions.getSliderValue(), 53);
    }

}
