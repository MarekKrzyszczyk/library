package model;

public class Author {
    private static int id;
    private int authorId;
    private String name;
    private String lastName;

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.authorId = id;
        id++;
    }
}
