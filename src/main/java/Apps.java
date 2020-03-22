import model.Author;
import model.Customer;
import service.BookService;

public class Apps {
    public static void main(String[] args) {
    BookService service = new BookService();
    service.addBook("ksiazka", 2019, new Author("Marek", "Krz"), 3);
    service.lentBook(1, new Customer("ktos", "taki"));
        System.out.println(BookService.books);
        System.out.println(BookService.lentBooks);
    }
}
