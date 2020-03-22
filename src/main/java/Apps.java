import model.Author;
import model.Customer;
import service.BookService;

import java.util.Scanner;

public class Apps {
    public static void main(String[] args) {

        BookService service = new BookService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("1: add new book to library");
        System.out.println("2: lent a book");
        System.out.println("3: remove a book");
        System.out.println("4: findAllBooks");
        System.out.println("5: findBookDetails");
        System.out.println("6: findBookByTitle");
        System.out.println("7: findBooksByAuthor");
        System.out.println("8: findBooksByYear");
        System.out.println("9: findBookByTitleAndAuthor");
        System.out.println("10: exit");

        int input = 0;
        while (input != 10) {
            System.out.println("Input number of action you want to do: ");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    System.out.println("Input title of book: ");
                    String titleOfNewBook = scanner.nextLine();
                    System.out.println("Input year: ");
                    int yearOfNewBook = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Input name of Author: ");
                    String nameOfAuthor = scanner.nextLine();
                    System.out.println("Input lastName of Author: ");
                    String lastNameOfAuthor = scanner.nextLine();
                    Author authorOfNewBook = new Author(nameOfAuthor, lastNameOfAuthor);
                    System.out.println("Input number of copies: ");
                    Integer nbOfCopies = scanner.nextInt();
                    scanner.nextLine();
                    service.addBook(titleOfNewBook, yearOfNewBook, authorOfNewBook, nbOfCopies);
                    break;
                case 2:
                    System.out.println("Input id of book you want to lent: ");
                    Integer idOfLentBook = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Input name of Customer: ");
                    String nameOfCustomer = scanner.nextLine();
                    System.out.println("Input name of Customer: ");
                    String lastNameOfCustomer = scanner.nextLine();
                    Customer customer = new Customer(nameOfCustomer, lastNameOfCustomer);
                    service.lentBook(idOfLentBook, customer);
                    break;
                case 3:
                    System.out.println("Input id of book to remove");
                    Integer id = scanner.nextInt();
                    service.removeBook(id);
                    break;
                case 4:
                    System.out.println("List of all books:");
                    service.findAllBooks();
                    break;
                case 5:
                    System.out.println("Input id of book to display details");
                    Integer idOfDisplyBook = scanner.nextInt();
                    service.findBookDetailsById(idOfDisplyBook);
                    break;
                case 6:
                    System.out.println("Input title of book you want to find");
                    String title = scanner.nextLine();
                    System.out.println(service.findBookByTitle(title));
                    break;
                case 7:
                    System.out.println("Input name of Author of books you want to find");
                    String name = scanner.nextLine();
                    System.out.println("Input lastName of Author of book you want to find");
                    String lastName = scanner.nextLine();
                    Author author = new Author(name, lastName);
                    System.out.println(service.findBooksByAuthor(author));
                    break;
                case 8:
                    System.out.println("Input year of production of books you want to find");
                    int year = scanner.nextInt();
                    System.out.println(service.findBooksByYear(year));
                    break;
                case 9:
                    System.out.println("Input title of book you want to find");
                    String title1 = scanner.nextLine();
                    System.out.println("Input name of Author of books you want to find");
                    String name1 = scanner.nextLine();
                    System.out.println("Input lastName of Author of book you want to find");
                    String lastName1 = scanner.nextLine();
                    Author author1 = new Author(name1, lastName1);
                    System.out.println(service.findBookByTitleAndAuthor(title1, author1));
                    break;
            }
        }
    }
}
