package api.requests;

import api.models.*;
import api.settings.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class BooksRequests {
    private final static BaseRequest baseRequest = new BaseRequest();


    public static List<Book> getAllBooks() {
        Response response = baseRequest.get(Endpoints.BOOKS.getUrl());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Book> books = null;
        String responseForMapper = response.getBody().asString();
        try {
            Map<String, List<Book>> result = objectMapper.readValue(responseForMapper, new TypeReference<Map<String, List<Book>>>() {});
            books = result.get("books");
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return books;
    }

    public static BookPostResponse postBooks(BookPost bookPost, String token) {
        Response response = baseRequest.post(Endpoints.BOOKS.getUrl(), bookPost, token);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Status code:" + response.getStatusCode());
        try {
            return objectMapper.readValue(response.getBody().asString(), BookPostResponse.class);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return null;
    }

    public static Token getToken( User user) {
        Response response = baseRequest.getToken(Endpoints.GET_TOKEN.getUrl(), user);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().asString(), Token.class);
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println(jsonProcessingException);
        }
        return null;
    }

    public static int deleteBook( BookDelete bookDelete, String token) {
        Response response = baseRequest.delete(Endpoints.BOOK.getUrl(), bookDelete, token);
        return response.getStatusCode();
    }
}
