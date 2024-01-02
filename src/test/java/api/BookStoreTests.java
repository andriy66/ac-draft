package api;

import api.models.Books;
import api.requests.BooksRequests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.BaseApi.URL;

public class BookStoreTests {
    @Test
    public void getBooks() {
        List<Books> books = BooksRequests.getAllBooks(URL);
        Assertions.assertEquals(books.size(), 8);
    }
}
