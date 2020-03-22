import model.Author;
import model.Customer;
import service.BookService;

public class Apps {
    public static void main(String[] args) {
    BookService service = new BookService();
    service.addBook("ksiazka", 2019, new Author("Marek", "Krz"), 3);
    service.addBook("inna ksiazka", 2019, new Author("Toemk", "pddd"), 3);
    service.lentBook(2, new Customer("ciekawe", "ktoryto"));
    service.lentBook(1, new Customer("ktos", "taki"));
    service.lentBook(1, new Customer("inny", "gostek"));

        System.out.println(BookService.books);
        System.out.println("---------------------------");
        System.out.println(BookService.lentBooks);
        System.out.println("---------------------------");
        service.findAllBooks();
    }
}
