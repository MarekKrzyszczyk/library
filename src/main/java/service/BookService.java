package service;

import model.Author;
import model.Book;
import model.Customer;

import java.util.*;

public class BookService implements BookServiceInt {

    public static Map<Book, Integer> books = new HashMap<>();
    public static Map<Book, List<Customer>> lentBooks = new HashMap<>();

    @Override
    public void addBook(String title, int year, Author author, int numberOfCopies) {
        Book newBook = new Book(title, year, author);
        books.put(newBook, numberOfCopies);
    }

    public Boolean checkIfExistSearchingBook(Integer id) {
        try {
            findBookById(id).getBookId();
        } catch (NullPointerException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    public boolean addLentBook(Book book, Customer customer) {
        for (Book lentBook : lentBooks.keySet()) {
            if (lentBook.getTitle().equals(book.getTitle())) {
                lentBooks.get(lentBook).add(customer);
                lentBooks.put(lentBook, lentBooks.get(lentBook));
                return true;
            }
        }
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        lentBooks.put(book, customers);
        return false;
    }

    @Override
    public void lentBook(Integer id, Customer customer) {
        if (checkIfExistSearchingBook(id)) {
            Book bookToLent = findBookById(id);
            Integer bookToLentValue = books.get(bookToLent);
            if (bookToLentValue > 0) {
                books.put(bookToLent, bookToLentValue - 1);
                if (lentBooks.size() == 0) {
                    lentBooks.put(bookToLent, new ArrayList<>(Arrays.asList(customer)));
                } else {
                    addLentBook(bookToLent, customer);
                }
            } else {
                System.out.println("There is no book in library to lent");
            }
        } else {
            System.out.println("There is no book in library to lent");
        }

    }

    @Override
    public void removeBook(Integer id) {

    }

    @Override
    public Book findBookById(Integer bookId) {
        for (Book book : books.keySet()) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }

        System.out.println("Book with id= " + bookId + " doesn't exist");

        return new Book();
    }

    public void findBookDetailsById(Integer bookId) {
        if (checkIfExistSearchingBook(bookId)) {
            for (Map.Entry<Book, Integer> entry : books.entrySet()) {
                if (entry.getKey().getBookId().equals(bookId)) {
                    if (entry.getValue() > 0) {
                        System.out.println(entry.getKey() + " is available for lent");
                        printLentBooksDetails(entry);
                    } else {
                        System.out.println(entry.getKey() + " is not available for lent");
                        printLentBooksDetails(entry);
                    }
                }
            }
        } else {
            System.out.println("Book with id= " + bookId + " doesn't exist");
        }
    }

    @Override
    public Book findBookByTitle(String title) {
        for (Book book : books.keySet()) {
            if (book.getTitle().equals(title)) {
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
            if (book.getAuthor().equals(author)) {
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
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }

        System.out.println("Book with title= " + title + " and author= " + author + " doesn't exist");

        return new Book();
    }

    public void printLentBooksDetails(Map.Entry<Book, Integer> entry) {
        for (Map.Entry<Book, List<Customer>> e : lentBooks.entrySet()) {
            if (entry.getKey().getTitle().equals(e.getKey().getTitle())) {
                System.out.println("copies are lent by:" + e.getValue());
            }
        }
    }

    @Override
    public void findAllBooks() {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + " is available for lent");
                printLentBooksDetails(entry);
            } else {
                System.out.println(entry.getKey() + " is not available for lent");
                printLentBooksDetails(entry);
            }
        }

    }
}
