package actions;

import pages.WidgetsPage;

public class WidgetsPageActions {
    private WidgetsPage widgetsPage = new WidgetsPage();

    public void chooseTab(String tab) {
        widgetsPage.sliderTab(tab).click();
    }
}
