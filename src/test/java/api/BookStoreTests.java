package api;

import api.models.*;
import api.requests.BooksRequests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static api.BaseApi.*;

public class BookStoreTests {
    private User user = new User();
    private String token = null;

    @BeforeEach
    public void setUp() {
        user.setPassword(PASSWORD);
        user.setUserName(USERNAME);
        token = BooksRequests.getToken(URL, user).getToken();
    }

    @Test
    public void getBooks() {
        List<Book> books = BooksRequests.getAllBooks(URL);
        Assertions.assertEquals(books.size(), 8);
    }

    @Test
    public void postBook() {
        BookPost bookPost = new BookPost();
        bookPost.setUserId(USER_ID);
        ISBN isbn = new ISBN();
        List<Book> books = BooksRequests.getAllBooks(URL);
        String expectedISBN = books.get(2).getIsbn();
        isbn.setIsbn(expectedISBN);
        bookPost.setCollectionOfIsbns(List.of(isbn));

        BookPostResponse response = BooksRequests.postBooks(URL, bookPost, token);
        Assertions.assertEquals(response.getBooks().get(0).getIsbn(), expectedISBN);
    }
}
