package stream;

import lambda.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*1.	(1 point) Create the following classes:
a.	Author with fields:
i.	String name
ii.	short age
iii.	List<Book> books
b.	Book with fields
i.	String title
ii.	List<Author> authors
iii.	int numberOfPages

2.	(1 points) Create two arrays: Author[] authors and Book[] books.
Their elements must use elements from the neighboring array.


4.	(2 points) Use peek method for debugging intermediate streams during execution the previous task.
5.	(2 points) Use parallel stream with subtask #3.
6.	(1 point) Use the Option type for determining the title of the biggest book of some author.
*/
public class Stream_task {
    public static void main(String[] agrs) {

        Author author1 = new Author("JRowling", (short) 45);

        Book author1Book1 = new Book("Harry Potter.Book 1", author1, 350);
        Book author1Book2 = new Book("Harry Potter.Book 2", author1, 197);
        Book author1Book3 = new Book("Stranges beasts", author1, 257);

        author1.getBooks().add(author1Book1);
        author1.getBooks().add(author1Book2);
        author1.getBooks().add(author1Book3);

        Author author2 = new Author("AlDjuma", (short) 68);

        Book author2Book1 = new Book("The tree masketiers", author2, 459);
        Book author2Book2 = new Book("Ten years ago", author2, 700);
        Book author2Book3 = new Book("Two Dianes", author2, 300);

        author2.getBooks().add(author2Book1);
        author2.getBooks().add(author2Book2);
        author2.getBooks().add(author2Book3);

        Author author3 = new Author("TooveJenson", (short) 37);

        Book author3Book1 = new Book("Mummy-Throll and his friends", author3, 140);
        Book author3Book2 = new Book("Mummy-Throll. The commet is coming", author3, 200);
        Book author3Book3 = new Book("Mummy-Throll. Winter dreams", author3, 228);

        author3.getBooks().add(author3Book1);
        author3.getBooks().add(author3Book2);
        author3.getBooks().add(author3Book3);


        List<Author> authors = Arrays.asList(author1, author2, author3);
        //     List<Book> booksList=Arrays.asList(author1.getBooks(),author2.getBooks(),author3.getBooks());


        List<Book> books = Stream.concat(author1.getBooks().stream(), author2.getBooks().stream())
                .collect(Collectors.toList());
        List<Book> booksList = Stream.concat(books.stream(), author3.getBooks().stream())
                .collect(Collectors.toList());

/*3.	Create a stream of books and then:
a.	check if some/all book(s) have more than 200 pages;
b.	find the books with max and min number of pages;
c.	filter books with only single author;
d.	sort the books by number of pages/title;
e.	get list of all titles;
f.	print them using forEach method;
g.	get distinct list of all authors*/

//

        System.out.println("______________check if some/all book(s) have more than 200 pages ___________");
        booksList.stream()
                .filter(book -> book.getNumberOfPages() > 200)
                .map(book -> book.title)
                .forEach(book -> System.out.println(book));

        System.out.println("_________________ find the books with max and min number of pages_______________");

        Book bookMaxPages = booksList.stream()
                .max((book1, book2) -> book1.numberOfPages > book2.numberOfPages ? 1 : -1)
                .get();
        System.out.println(bookMaxPages.numberOfPages);


        Book booksMinPages = booksList.stream()
                .max((book1, book2) -> book1.numberOfPages < book2.numberOfPages ? 1 : -1)
                .get();
        System.out.println(booksMinPages.numberOfPages);

        System.out.println("\n____sort the books by number of pages + ) Use peek method for debugging" +
                " intermediate streams during execution the previous task. __________\n");
        booksList.stream()

                .sorted(Comparator.comparing(book -> book.getNumberOfPages()))
                .map(book -> book.title)
                .peek(book -> System.out.println("Book:  " + book))
                .collect(Collectors.toList())
        ;


        System.out.println("____________sort the books by title______________");

        booksList.stream()
                .sorted(Comparator.comparing(book -> book.getTitle()))
                .map(book -> book.title)
                .forEach(book -> System.out.println(book));

        System.out.println("__________ get list of all titles + print them using forEach method__________");
        booksList.stream()
                .map(book -> book.getTitle())

                .collect(Collectors.toList())
                .forEach(book -> System.out.println(book));

        System.out.println("_____________get distinct list of all authors _______");
        authors.stream()
                .map(author -> author.getName())
               // .parallel()
                  .distinct()
                .collect(Collectors.toList())
                .forEach(author -> System.out.println(author));


        System.out.println("__________Use peek method for debugging intermediate streams +  Use parallel stream with subtask #3_____");
        books.stream()
                .map(book -> book.getNumberOfPages())
                .peek((book) -> System.out.println("B  " + book + " pages"))
                .parallel()
                .collect(Collectors.toList());
    }


}
