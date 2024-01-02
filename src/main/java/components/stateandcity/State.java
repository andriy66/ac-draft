package components.stateandcity;

import com.codeborne.selenide.SelenideElement;
import components.BaseComponents;

import java.util.List;

public enum State implements BaseComponents {
    NCR(List.of(City.DELHI, City.GURGAON, City.NOIDA),  "NCR"),
    UTTAR_PRADESH(List.of(City.AGRA, City.MERRUT, City.LUCKNOW), "Uttar Pradesh"),
    HARYANA(List.of(City.KARNAL, City.PANIPAT), "Haryana"),
    RAJASTHAN(List.of(City.JAIPUR, City.JAISELMER), "Rajasthan");

    private List<City> cities;
    private SelenideElement stateElement;
    private String stateName;

    State(List<City> cities, String stateName) {
        this.cities = cities;
        this.stateName = stateName;
    }

    public List<City> getStateCities() {
        return cities;
    }
    public String getStateName() {
        return stateName;
    }

    public SelenideElement getStateElement() {
        stateElement = getElementByText(stateName);
        return stateElement;
    }
}
