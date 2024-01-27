package api.models;

import annotations.OptionalField;

import java.util.List;

public class BookPostResponse {

    @OptionalField
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
