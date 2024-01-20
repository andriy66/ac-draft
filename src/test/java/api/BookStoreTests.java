package api;

import api.models.*;
import api.requests.BooksRequests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static api.BaseApi.*;

public class BookStoreTests {
    private User user = new User();
    private String token = null;
    private BookDelete bookDelete;

    @BeforeTest
    public void setUp() {
        user.setPassword(PASSWORD);
        user.setUserName(USERNAME);
        token = BooksRequests.getToken(URL, user).getToken();
        bookDelete = new BookDelete();
        if(!BooksRequests.getAllBooks(URL).isEmpty()) {
            deleteAllBooks(BooksRequests.getAllBooks(URL));
        }
    }

    @Test
    public void getBooks() {
        List<Book> books = BooksRequests.getAllBooks(URL);
        Assert.assertEquals(books.size(), 8);
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

        Assert.assertEquals(response.getBooks().get(0).getIsbn(), expectedISBN);
    }

    @AfterTest
    public void deleteUselessBooks() {
        if(bookDelete != null) {
            int statusCode = BooksRequests.deleteBook(URL, bookDelete, token);
            Assert.assertEquals(statusCode, 204, "The book didnt deleted from the cart");
        }
    }

    private void deleteAllBooks(List<Book> books) {
        for (String isbn: books.stream().map(Book::getIsbn).toList()) {
            BookDelete bookForDeleting = new BookDelete();
            bookForDeleting.setUserId(USER_ID);
            bookForDeleting.setIsbn(isbn);
            BooksRequests.deleteBook(URL, bookForDeleting, token);
        }
    }
}
