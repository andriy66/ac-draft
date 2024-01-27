package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserID implements Model {
    @JsonProperty("UserId")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
