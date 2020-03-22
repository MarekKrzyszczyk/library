package service;

import model.Book;

import java.util.Set;

public interface BookServiceInt {

    void addBook();

    void lentBook(int id);

    void removeBook(int id);

    Book findBookById(int bookId);

    Book findBookByTitle(String title);

    Book findBookByAuthor(String Author);

    Book findBookByYear(int Year);

    Book findBookByTitleAndAuthor(String title, String Author);

    Set<Book> findAllBooks();
}
