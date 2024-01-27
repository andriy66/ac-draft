package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ConfigReader {
    URL("url"), BROWSER("browser"), USERNAME("username"), PASSWORD("password"),
    USER_ID("userId");

    public String param;
    private final String FILE_URL = "src/test/resources/config.properties";

    ConfigReader(String param) {
        this.param = param;
    }

    public String getParameterValue() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(FILE_URL)) {
            properties.load(inputStream);
            return (String) properties.get(param);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
