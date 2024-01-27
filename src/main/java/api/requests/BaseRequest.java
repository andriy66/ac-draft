package api.requests;

import api.models.User;
import api.models.Model;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    private final String URL = ConfigReader.URL.getParameterValue();
    public Response get(String path) {
        RestAssured.baseURI = URL;
        return given().when().get(path).thenReturn();
    }

    public Response post(String path, Model model, String token) {
        RestAssured.baseURI = URL;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(model);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(jsonString)
                .when()
                .post(path)
                .thenReturn();
    }

    public Response post(String path, Model model) {
        RestAssured.baseURI = URL;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(model);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return given().contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post(path)
                .thenReturn();
    }

    public Response delete(String path, Model model, String token) {
        RestAssured.baseURI = URL;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(model);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(jsonString)
                .when()
                .delete(path)
                .thenReturn();
    }

    public Response delete(String path, String token) {
        RestAssured.baseURI = URL;
        return given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(path)
                .thenReturn();
    }

    public Response getToken(String path, User auth) {
        RestAssured.baseURI = URL;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(auth);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return given().contentType(ContentType.JSON).body(jsonString).when().post(path).thenReturn();
    }
}
