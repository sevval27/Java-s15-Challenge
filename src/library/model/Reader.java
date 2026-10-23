package library.model;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {

    private List<Book> books;
    private static final int MAX_BOOK_LIMIT = 5;

    public Reader(String name) {
        super(name);
        books = new ArrayList<>();
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a reader.");
    }

    public void borrowBook(Book book) {

        if (books.size() >= MAX_BOOK_LIMIT) {
            System.out.println(
            "You cannot borrow more than 5 books."
            );
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("This book is not available.");
            return;
        }

        books.add(book);
        book.setStatus("Borrowed");

        System.out.println(
                "\"" + book.getName() + "\" borrowed successfully."
        );
    }

    public void returnBook(Book book) {

        if (books.remove(book)) {
            book.setStatus("Available");

            System.out.println(
                    "\"" + book.getName() + "\" returned successfully."
            );
        } else {
            System.out.println("This book was not borrowed by this reader.");
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
