package service;

import model.Author;
import model.Book;

import java.util.List;
import java.util.Set;

public interface BookServiceInt {

    void addBook(String title, int year, Author author, int numberOfCopies);

    void lentBook(Integer id);

    void removeBook(Integer id);

    Book findBookById(Integer bookId);

    Book findBookByTitle(String title);

    List<Book> findBookByAuthor(Author author);

    List<Book> findBookByYear(int year);

    Book findBookByTitleAndAuthor(String title, Author author);

    List<Book> findAllBooks();
}
