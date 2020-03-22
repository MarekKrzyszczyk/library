package model;

public class Customer {
    private static int id;
    private int customerId;
    private String name;
    private String lastName;

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.customerId = id;
        id++;
    }
}
