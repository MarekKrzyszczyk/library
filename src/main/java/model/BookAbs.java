package model;

import java.util.Objects;

public abstract class BookAbs {
    private String title;
    private int year;
    private Author author;

    public BookAbs(String title, int year, Author author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public BookAbs() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAbs bookAbs = (BookAbs) o;
        return year == bookAbs.year &&
                Objects.equals(title, bookAbs.title) &&
                Objects.equals(author, bookAbs.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, author);
    }
}
