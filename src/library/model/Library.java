package library.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {

    private Map<Integer, Book> books;
    private Set<Reader> readers;

    private List<Loan> loans;
    private List<Invoice> invoices;

    private int nextLoanId = 1;
    private int nextInvoiceId = 1;

    public Library() {
        books = new HashMap<>();
        readers = new HashSet<>();
        loans = new ArrayList<>();
        invoices = new ArrayList<>();
    }


    // BOOK EKLEME


    public void newBook(Book book) {

        if (books.containsKey(book.getBookId())) {
            System.out.println("Bu ID ile zaten bir kitap var.");
            return;
        }

        books.put(book.getBookId(), book);

        System.out.println("Kitap başarıyla eklendi.");
    }

  
    // READER EKLEME
  

    public void addReader(Reader reader) {
        readers.add(reader);
    }


    // ID İLE KİTAP BULMA
   

    public Book getBook(int bookId) {
        return books.get(bookId);
    }


    // KİTAP SİLME
  

    public void deleteBook(int bookId) {
    Book book = books.get(bookId);

    if (book == null) {
        System.out.println("Kitap bulunamadı.");
        return;
    }

    if (!book.isAvailable()) {
        System.out.println(
            "Ödünçteki kitap silinemez."
        );
        return;
    }

    books.remove(bookId);
    System.out.println("Kitap başarıyla silindi.");
}


    // TÜM KİTAPLARI GÖSTER


    public void showBooks() {

        if (books.isEmpty()) {
            System.out.println("Kütüphanede kitap yok.");
            return;
        }

        for (Book book : books.values()) {
            book.display();
        }
    }


    // Kitap İSMİNE GÖRE ARAMA


    public List<Book> searchByName(String name) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                result.add(book);
            }
        }

        return result;
    }

    // KATEGORİYE GÖRE ARAMA
    
    public List<Book> searchByCategory(String categoryName) {
    List<Book> result = new ArrayList<>();

    for (Book book : books.values()) {
        Category category = book.getCategory();

        if (category != null
                && category.getName()
                    .equalsIgnoreCase(categoryName)) {
            result.add(book);
        }
    }

    return result;
    }

    // YAZARA GÖRE ARAMA


    public List<Book> searchByAuthor(String authorName) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getAuthor()
                    .getName()
                    .toLowerCase()
                    .contains(authorName.toLowerCase())) {

                result.add(book);
            }
        }

        return result;
    }


    // KİTAP GÜNCELLEME


    public void updateBook(
            int bookId,
            String newName,
            double newPrice,
            int newEdition) {

        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("Kitap bulunamadı.");
            return;
        }

        book.setName(newName);
        book.setPrice(newPrice);
        book.setEdition(newEdition);

        System.out.println("Kitap güncellendi.");
    }


    // READERLARI GÖSTER


    public void showReaders() {

        for (Reader reader : readers) {
            System.out.println(reader.getName());
        }
    }


    //Ödünç alma işlemi

    public void borrowBook(Reader reader, int bookId) {
    Book book = books.get(bookId);

    if (book == null) {
        System.out.println("Book not found.");
        return;
    }

    if (!readers.contains(reader)) {
        System.out.println("Reader is not registered.");
        return;
    }

    if (!book.isAvailable()) {
        System.out.println("Book is not available.");
        return;
    }

    if (reader.getBooks().size() >= 5) {
        System.out.println("The 5-book limit has been reached.");
        return;
    }

    reader.borrowBook(book);

    if (!reader.getBooks().contains(book)) {
        return;
    }

    Loan loan = new Loan(nextLoanId++, book, reader);
    loans.add(loan);

    // Demo rule: book price is treated as a refundable deposit.
    invoices.add(new Invoice(
            nextInvoiceId++,
            loan.getLoanId(),
            reader.getName(),
            book.getName(),
            "CHARGE",
            book.getPrice()
    ));

    System.out.println("Loan created successfully.");
    System.out.println("Deposit charged: " + book.getPrice() + " TL");
}

//İade işlemi
public void returnBook(Reader reader, int bookId) {
    Loan activeLoan = null;

    for (Loan loan : loans) {
        if (loan.getBook().getBookId() == bookId
                && loan.getReader() == reader
                && loan.isActive()) {
            activeLoan = loan;
            break;
        }
    }

    if (activeLoan == null) {
        System.out.println(
                "No active loan found for this reader and book.");
        return;
    }

    Book book = activeLoan.getBook();

    reader.returnBook(book);

    if (reader.getBooks().contains(book)) {
        System.out.println("Return could not be completed.");
        return;
    }

    activeLoan.completeReturn();

    invoices.add(new Invoice(
            nextInvoiceId++,
            activeLoan.getLoanId(),
            reader.getName(),
            book.getName(),
            "REFUND",
            book.getPrice()
    ));

    System.out.println("Book returned successfully.");
    System.out.println("Refund recorded: " + book.getPrice() + " TL");
}
    //ÖDÜNÇ KAYITLARINI GÖSTERME
    
public void showLoans() {
    if (loans.isEmpty()) {
        System.out.println("No loan records.");
        return;
    }

    for (Loan loan : loans) {
        System.out.println(loan);
    }
}

public void showInvoices() {
    if (invoices.isEmpty()) {
        System.out.println("No invoice records.");
        return;
    }

    for (Invoice invoice : invoices) {
        invoice.display();
    }
}

}
