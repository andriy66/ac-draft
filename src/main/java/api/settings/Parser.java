package api.settings;

import api.models.Model;
import api.models.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class Parser {
    private final Class type;

    public Parser(Class type) {
        this.type = type;
    }

    public Object parse(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().asString(), type);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return null;
    }
}
