package model;

public class Customer {
    private String name;
    private String lastName;

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastName;
    }
}
