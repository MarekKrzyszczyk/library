package service;

import model.Author;
import model.Book;
import model.Customer;
import model.LentBook;

import java.util.*;

public class BookService implements BookServiceInt {

    public static Map<Book, Integer> books = new HashMap<>();
    public static Map<LentBook, Integer> lentBooks = new HashMap<>();

    @Override
    public void addBook(String title, int year, Author author, int numberOfCopies) {
        Book newBook = new Book(title, year, author);
        books.put(newBook, numberOfCopies);
    }

    @Override
    public void lentBook(Integer id, Customer customer) {
        Book bookToLent = findBookById(id);
        LentBook lentBook = new LentBook(id, bookToLent.getTitle(), bookToLent.getYear(), bookToLent.getAuthor(), customer);
        System.out.println(lentBook);
        Integer bookToLentValue = books.get(bookToLent);
        if (bookToLentValue > 0) {
            books.put(bookToLent, bookToLentValue - 1);
            for (LentBook book : lentBooks.keySet()) {
                if (book.getTitle().equals(bookToLent.getTitle())) {
                    lentBooks.put(lentBook, lentBooks.get(lentBook) + 1);
                } else {
                    lentBooks.put(lentBook, 1);
                }
            }
        } else {
            System.out.println("There is no book to lent");
        }
    }

    @Override
    public void removeBook(Integer id) {

    }

    @Override
    public Book findBookById(Integer bookId) {
        for (Book book : books.keySet()) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        System.out.println("Book with id= " + bookId + " doesn't exist");

        return new Book();
    }

    @Override
    public Book findBookByTitle(String title) {
        for (Book book : books.keySet()) {
            if (book.getTitle() == title) {
                return book;
            }
        }

        System.out.println("Book with title= " + title + " doesn't exist");

        return new Book();
    }

    @Override
    public List<Book> findBookByAuthor(Author author) {
        List<Book> authorsBooks = new ArrayList<>();
        for (Book book : books.keySet()) {
            if (book.getAuthor() == author) {
                authorsBooks.add(book);
            }
        }
        return authorsBooks;
    }

    @Override
    public List<Book> findBookByYear(int year) {
        List<Book> booksInYear = new ArrayList<>();
        for (Book book : books.keySet()) {
            if (book.getYear() == year) {
                booksInYear.add(book);
            }
        }
        return booksInYear;
    }

    @Override
    public Book findBookByTitleAndAuthor(String title, Author author) {
        for (Book book : books.keySet()) {
            if (book.getTitle() == title && book.getAuthor() == author) {
                return book;
            }
        }

        System.out.println("Book with title= " + title + " and author= " + author + " doesn't exist");

        return new Book();
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        for (Book book : books.keySet()) {
            allBooks.add(book);
        }
        System.out.println(allBooks);
        return allBooks;
    }
}
