
package library;

import library.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();
    private static final Reader reader = new Reader("Ali");

    public static void main(String[] args) {
        library.addReader(reader);

        Author author = new Author(1, "George Orwell");
        Category category = new Category(1, "Science Fiction");

        library.newBook(new Book(
                1984, author, category,
                "1984", 100, "Available", 1, "2025-01-10"
        ));

        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> addBook();
                    case "2" -> library.showBooks();
                    case "3" -> searchById();
                    case "4" -> searchByName();
                    case "5" -> searchByAuthor();
                    case "6" -> searchByCategory();
                    case "7" -> updateBook();
                    case "8" -> deleteBook();
                    case "9" -> borrowBook();
                    case "10" -> returnBook();
                    case "11" -> library.showReaders();
                    case "12" -> library.showLoans();
                    case "13" -> library.showInvoices();
                    case "0" -> running = false;
                    default -> System.out.println(
                            "Invalid option."
                    );
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid number."
                );
            } catch (IllegalArgumentException |
                     IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
        System.out.println("Library system closed.");
    }

    private static void showMenu() {
        System.out.println("===== LIBRARY SYSTEM =====");
        System.out.println("1. Add book");
        System.out.println("2. Show all books");
        System.out.println("3. Search book by ID");
        System.out.println("4. Search books by name");
        System.out.println("5. Search books by author");
        System.out.println("6. Search books by category");
        System.out.println("7. Update book");
        System.out.println("8. Delete book");
        System.out.println("9. Borrow book");
        System.out.println("10. Return book");
        System.out.println("11. Show readers");
        System.out.println("12. Show loan records");
        System.out.println("13. Show invoices");
        System.out.println("0. Exit");
    }

    private static void addBook() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Book name: ");
        String name = scanner.nextLine();

        System.out.print("Author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Category name: ");
        String categoryName = scanner.nextLine();

        System.out.print("Price/deposit: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Edition: ");
        int edition = Integer.parseInt(scanner.nextLine());

        Author author = new Author(id, authorName);
        Category category = new Category(id, categoryName);

        Book book = new Book(
                id, author, category, name, price,
                "Available", edition,
                java.time.LocalDate.now().toString()
        );

        library.newBook(book);
    }

    private static void searchById() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Book book = library.getBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            book.display();
        }
    }

    private static void searchByName() {
        System.out.print("Book name: ");
        String name = scanner.nextLine();

        printBooks(library.searchByName(name));
    }

    private static void searchByAuthor() {
        System.out.print("Author name: ");
        String name = scanner.nextLine();

        printBooks(library.searchByAuthor(name));
    }

    private static void searchByCategory() {
        System.out.print("Category name: ");
        String name = scanner.nextLine();

        printBooks(library.searchByCategory(name));
    }

    private static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No matching books found.");
            return;
        }

        for (Book book : books) {
            book.display();
        }
    }

    private static void updateBook() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New name: ");
        String name = scanner.nextLine();

        System.out.print("New price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("New edition: ");
        int edition = Integer.parseInt(scanner.nextLine());

        library.updateBook(id, name, price, edition);
    }

    private static void deleteBook() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        library.deleteBook(id);
    }

    private static void borrowBook() {
        System.out.print("Book ID to borrow: ");
        int id = Integer.parseInt(scanner.nextLine());

        library.borrowBook(reader, id);
    }

    private static void returnBook() {
        System.out.print("Book ID to return: ");
        int id = Integer.parseInt(scanner.nextLine());

        library.returnBook(reader, id);
    }
}
