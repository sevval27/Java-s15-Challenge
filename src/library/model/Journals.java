package library.model;

public class Journals extends Book {

    public Journals(
            int bookId,
            Author author,
            String name,
            double price,
            String status,
            int edition,
            String dateOfPurchase) {

        super(
            bookId,
            author,
            name,
            price,
            status,
            edition,
            dateOfPurchase
        );
    }
}