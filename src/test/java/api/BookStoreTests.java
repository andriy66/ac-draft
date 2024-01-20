package api;

import api.models.*;
import api.requests.BooksRequests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.BaseApi.*;

public class BookStoreTests {
    private User user = new User();
    private String token = null;
    private BookDelete bookDelete;

    @BeforeEach
    public void setUp() {
        user.setPassword(PASSWORD);
        user.setUserName(USERNAME);
        token = BooksRequests.getToken(URL, user).getToken();
        bookDelete = new BookDelete();
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
        String expectedISBN = books.get(0).getIsbn();
        isbn.setIsbn(expectedISBN);
        bookPost.setCollectionOfIsbns(List.of(isbn));

        BookPostResponse response = BooksRequests.postBooks(URL, bookPost, token);
        bookDelete.setIsbn(response.getBooks().get(0).getIsbn());
        bookDelete.setUserId(USER_ID);
        
        Assertions.assertEquals(response.getBooks().get(0).getIsbn(), expectedISBN);
    }

    @AfterEach
    public void deleteUselessBooks() {
        if(bookDelete != null) {
            int statusCode = BooksRequests.deleteBook(URL, bookDelete, token);
            Assertions.assertEquals(statusCode, 204, "The book didnt deleted from the cart");
        }
    }
}
