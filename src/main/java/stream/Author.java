package stream;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private short age;

  private List<Book> books=new ArrayList<>();


    public Author(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }
}
