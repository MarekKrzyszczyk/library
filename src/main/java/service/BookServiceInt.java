package service;

import model.Author;
import model.Book;
import model.Customer;

import java.util.List;

public interface BookServiceInt {

    void addBook(String title, int year, Author author, int numberOfCopies);

    void lentBook(Integer id, Customer customer);

    void removeBook(Integer id);

    Book findBookById(Integer bookId);

    Book findBookByTitle(String title);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByYear(int year);

    Book findBookByTitleAndAuthor(String title, Author author);

    void findAllBooks();
}
