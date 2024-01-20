package api.settings;

public enum Endpoints {
    USER("User"), BOOKS("BookStore/v1/Books"), BOOK("BookStore/v1/Book"), GET_TOKEN("Account/v1/GenerateToken");

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
