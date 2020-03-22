package model;

public class LentBook extends BookAbs{
    private Customer customer;
    private Integer lentBookId;

    public LentBook(Integer id, String title, int year, Author author, Customer customer) {
        super(title, year, author);
        this.customer = customer;
        this.lentBookId = id;
    }

    @Override
    public String toString() {
        return "LentBook{" +
                "title " + super.getTitle() +
                ", customer=" + customer +
                ", lentBookId=" + lentBookId +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }
}
