package api;

import api.models.User;
import utils.ConfigReader;

public interface BaseApi {
    String USER_ID = ConfigReader.USER_ID.getParameterValue();
    String PASSWORD = ConfigReader.PASSWORD.getParameterValue();
    String USERNAME = ConfigReader.USERNAME.getParameterValue();
    User user = new User(USERNAME, PASSWORD);
}
