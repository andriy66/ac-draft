package api;

import base.ConfigReader;

public interface BaseApi {
    String URL = ConfigReader.URL.getParameterValue();
}
