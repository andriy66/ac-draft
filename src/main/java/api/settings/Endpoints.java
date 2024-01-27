package api.settings;

public enum Endpoints {
    BOOKS("BookStore/v1/Books"), BOOK("BookStore/v1/Book"),
    GET_TOKEN("Account/v1/GenerateToken"),
    USER_AUTHORIZED("Account/v1/Authorized"),
    USER("Account/v1/User");


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
