package components;

public enum Cards {
    FORMS("Forms"),
    ELEMENTS("Elements"),
    ALERTS_FRAME_WINDOWS("Alerts, Frame & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APP("Book Store Application");
    private String name;
    Cards(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
