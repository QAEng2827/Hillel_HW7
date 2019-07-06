package stream;

import java.util.List;

public class Book {
    String title;
    Author authors;
   // List<Author> authors;
    int numberOfPages;

    public Book(String title, Author authors, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
