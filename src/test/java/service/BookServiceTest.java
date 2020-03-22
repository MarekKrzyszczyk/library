package service;

import model.Author;
import model.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class BookServiceTest {

    private Book book = new Book("Inland: A Novel", 2019, new Author("TEA" ,"OBREHT"));
    private Book book2 = new Book("My Lovely Wife", 2019, new Author("SAMANTHA" ,"DOWNING"));
    private BookService service = new BookService();

    @Test
    void addBook() {
        service.addBook("American Spy", 2019, new Author("LAUREN" ,"WILKINSON"), 1);
        assertEquals(1, BookService.books.size());
    }

    @Test
    void lentBook() {
    }

    @Test
    void removeBook() {
        Book book = new Book("My Lovely Wife", 2019, new Author("SAMANTHA" ,"DOWNING"));
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        service.removeBook(1);
        assertEquals(0,BookService.books.size());
    }

    @Test
    void findBookById() {
        Book book = new Book("My Lovely Wife", 2019, new Author("SAMANTHA" ,"DOWNING"));
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        Book findedBook = service.findBookById(4);
        assertEquals(book, findedBook);
    }

    @Test
    void findBookByTitle() {
        Book book = new Book("Inland: A Novel", 2019, new Author("TEA" ,"OBREHT"));
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        Book findedBook = service.findBookByTitle("Inland: A Novel");
        assertEquals(book, findedBook);
    }

    @Test
    void findBookByAuthor() {
        Author author = new Author("LAUREN" ,"WILKINSON");
        Book book = new Book("American Spy", 2019, author);
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        List<Book> findedBooks = service.findBookByAuthor(author);
        assertEquals(book, findedBooks.get(0));
    }

    @Test
    void findBookByYear() {
        Book book = new Book("Inland: A Novel", 2019, new Author("TEA" ,"OBREHT"));
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        List<Book> findedBook = service.findBookByYear(2019);
        assertEquals(book, findedBook.get(0));
    }

    @Test
    void findBookByTitleAndAuthor() {
        Author author = new Author("LAUREN" ,"WILKINSON");
        Book book = new Book("Inland: A Novel", 2019, author);
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        Book findedBook = service.findBookByTitleAndAuthor("Inland: A Novel", author);
        assertEquals(book, findedBook);
    }
}