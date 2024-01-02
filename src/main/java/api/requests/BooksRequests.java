package api.requests;

import api.models.Books;
import api.settings.Endpoints;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BooksRequests {
    private final static BaseRequest baseRequest = new BaseRequest();

    public static List<Books> getAllBooks(String baseUrl) {
        Response response = baseRequest.get(baseUrl, Endpoints.BOOKS.getUrl());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Books> books = null;
        String responseForMapper = response.getBody().asString();
        try {
            Map<String, List<Books>> result = objectMapper.readValue(responseForMapper, new TypeReference<Map<String, List<Books>>>() {});
            books = result.get("books");
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return books;
    }
}
