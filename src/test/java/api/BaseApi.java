package api;

import api.models.User;
import base.ConfigReader;

public interface BaseApi {
    String URL = ConfigReader.URL.getParameterValue();
    String USER_ID = ConfigReader.USER_ID.getParameterValue();
    String PASSWORD = ConfigReader.PASSWORD.getParameterValue();
    String USERNAME = ConfigReader.USERNAME.getParameterValue();
}
