package api.models;

import annotations.OptionalField;

public class Token implements Model {
    private String token;

    @OptionalField
    private String expires;

    @OptionalField
    private String status;

    @OptionalField
    private String result;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", expires='" + expires + '\'' +
                ", status='" + status + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
