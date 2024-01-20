package api.models;

import annotations.OptionalField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book implements Model {
    private String isbn;
    @OptionalField
    private String title;

    @OptionalField
    private String subTitle;

    @OptionalField
    private String author;

    @OptionalField
    @JsonProperty("publish_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private String publishDate;

    @OptionalField
    private String publisher;

    @OptionalField
    private int pages;

    @OptionalField
    private String description;

    @OptionalField
    private String website;

    @Override
    public String toString() {
        return "Books{" +
                "\nisbn='" + isbn + '\'' +
                ",\n title='" + title + '\'' +
                ",\n subTitle='" + subTitle + '\'' +
                ",\n author='" + author + '\'' +
                ",\n publishDate='" + publishDate + '\'' +
                ",\n publisher='" + publisher + '\'' +
                ",\n pages=" + pages +
                ",\n description='" + description + '\'' +
                ",\n website='" + website + '\'' +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
