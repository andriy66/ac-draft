package api.requests;

import api.models.User;
import api.models.Model;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    public Response get(String baseUrl, String path) {
        RestAssured.baseURI = baseUrl;
        return given().when().get(path).thenReturn();
    }

    public Response post(String baseUrl, String path, Model model, String token) {
        RestAssured.baseURI = baseUrl;
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

    public Response delete(String baseUrl, String path, Model model, String token) {
        RestAssured.baseURI = baseUrl;
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

    public Response getToken(String baseUrl, String path, User auth) {
        RestAssured.baseURI = baseUrl;
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
