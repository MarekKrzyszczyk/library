package model;

import java.util.Objects;

public class Book extends BookAbs {
    private static Integer id =1;
    private Integer bookId;
//    private String title;
//    private int year;
//    private Author author;

    public Book(String title, int year, Author author) {
        super(title, year, author);
        this.bookId = id;
        id++;
    }

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + super.getTitle() + '\'' +
                ", year=" + super.getYear() +
                ", author=" + super.getAuthor() +
                '}';
    }
}
