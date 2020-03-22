package model;

public class Book {
    private static int id;
    private int bookId;
    private String title;
    private int year;
    private String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.bookId = id;
        id++;
    }


}
