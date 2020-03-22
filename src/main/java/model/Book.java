package model;

import java.util.Objects;

public class Book {
    private static Integer id =1;
    private Integer bookId;
    private String title;
    private int year;
    private Author author;

    public Book(String title, int year, Author author) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.bookId = id;
        id++;
    }

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, author);
    }
}
