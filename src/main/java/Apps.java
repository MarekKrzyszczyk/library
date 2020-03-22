import model.Author;
import service.BookService;

import java.util.Scanner;

public class Apps {
    public static void main(String[] args) {

        BookService service = new BookService();

        service.addBook("American Spy", 2019, new Author("LAUREN", "WILKINSON"), 1);
        service.addBook("Inland: A Novel", 2018, new Author("TEA", "OBREHT"), 2);
        service.addBook("My Lovely Wife", 2019, new Author("SAMANTHA", "DOWNING"), 1);
        service.findAllBooks();

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
        System.out.println("input to: " + input);
        while (input != 10) {
//            System.out.println("2: lent a book");
//            System.out.println("3: remove a book");
//            System.out.println("4: findAllBooks");
//            System.out.println("5: findBookDetails");
//            System.out.println("6: findBookByTitle");
//            System.out.println("7: findBooksByAuthor");
//            System.out.println("8: findBooksByYear");
//            System.out.println("9: findBookByTitleAndAuthor");
//            System.out.println("10: exit");
            System.out.println("Input number of action you want to do: ");
            input = scanner.nextInt();
           scanner.nextLine();
            System.out.println("input to: " + input);
            switch (input) {
                case 3:
                    System.out.println("Input id of book to remove");
                    Integer id = scanner.nextInt();
                    service.removeBook(id);
                    break;
                case 4:
                    System.out.println("List of all books:");
                    service.findAllBooks();
//                    int year = scanner.nextInt();
//                    System.out.println("Input title of book: ");
//                    String title = scanner.nextLine();
//                    System.out.println("Input year: ");
//                    int year = scanner.nextInt();
//                    System.out.println("Input name of Author: ");
//                    String name = scanner.nextLine();
//                    System.out.println("Input lastName of Author: ");
//                    String lastName = scanner.nextLine();
//                    Author author = new Author(name, lastName);
//                    System.out.println("Input number of copies: ");
//                    Integer nbOfCopies = scanner.nextInt();
//                    service.addBook(title, year, author, nbOfCopies);
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
                    System.out.println("Input name of Author of book you want to find");
                    String name = scanner.nextLine();
                    System.out.println("Input lastName of Author of book you want to find");
                    String lastName = scanner.nextLine();
                    Author author = new Author(name, lastName);
                    System.out.println(service.findBooksByAuthor(author));
                    break;
            }
        }


    }
}
