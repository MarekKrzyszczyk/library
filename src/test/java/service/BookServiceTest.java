package service;

import model.Author;
import model.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class BookServiceTest {

    private BookService service = new BookService();

    @Test
    void addBook() {
        int size = BookService.books.size();
        service.addBook("American Spy", 2019, new Author("LAUREN", "WILKINSON"), 1);
        assertEquals(size, BookService.books.size());
    }

//    @Test
//    void removeBook() {
//        int size = BookService.books.size();
//        service.removeBook(1);
//        assertEquals(size, BookService.books.size());
//    }

//    @Test
//    @DisplayName("findBookById")
//    void findBookById() {
//        Book book = new Book("My Lovely Wife", 2019, new Author("SAMANTHA", "DOWNING"));
//        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
//        Book findedBook = service.findBookById(1);
//        assertEquals(book, findedBook);
//    }

    @Test
    void findBookByTitle() {
        Book book = new Book("Inland: A Novel", 2018, new Author("TEA", "OBREHT"));
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        Book findedBook = service.findBookByTitle("Inland: A Novel");
        assertEquals(book, findedBook);
    }

    @Test
    void findBookByAuthor() {
        Author author = new Author("LAUREN", "WILKINSON");
        Book book = new Book("American Spy", 2019, author);
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        List<Book> findedBooks = service.findBooksByAuthor(author);
        assertEquals(book, findedBooks.get(0));
    }

    @Test
    void findBooksByYear() {
        Book book = new Book("Inland: A Novel", 2018, new Author("TEA", "OBREHT"));
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        List<Book> findedBook = service.findBooksByYear(2018);
        assertEquals(book, findedBook.get(0));
    }

    @Test
    void findBookByTitleAndAuthor() {
        Author author = new Author("TEA", "OBREHT");
        Book book = new Book("Inland: A Novel", 2018, author);
        service.addBook(book.getTitle(), book.getYear(), book.getAuthor(), 1);
        Book findedBook = service.findBookByTitleAndAuthor("Inland: A Novel", author);
        assertEquals(book, findedBook);
    }
}