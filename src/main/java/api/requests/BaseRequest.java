package api.requests;

import api.settings.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseRequest {

    public Response get(String baseUrl, String path) {
        RestAssured.baseURI = baseUrl;
        return given().when().get(path).thenReturn();
    }
//    public String post(String baseUrl, String path, Object object) {
//
//    }
}
