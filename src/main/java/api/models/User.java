package api.models;

import annotations.OptionalField;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User implements Model {
    @OptionalField
    private String userID;

    @JsonAlias({"UserName", "userName", "username", "user_name"})
    private String userName;
    private String password;
    @OptionalField
    private List<Book> books;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", books=" + books +
                '}';
    }
}
