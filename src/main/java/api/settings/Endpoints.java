package api.settings;

public enum Endpoints {
    USER("User"), BOOKS("BookStore/v1/Books"), BOOK("Book");

    private String url;

    Endpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String addParamAndGet(String additionalParam) {
        return String.format("%s/%s", url, additionalParam);
    }
}
