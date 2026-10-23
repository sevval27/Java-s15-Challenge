
package library.model;

import java.time.LocalDate;

public class Loan {

    private final int loanId;
    private final Book book;
    private final Reader reader;
    private final LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(int loanId, Book book, Reader reader) {
        this.loanId = loanId;
        this.book = book;
        this.reader = reader;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    public int getLoanId() {
        return loanId;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public void completeReturn() {
        if (!isActive()) {
            throw new IllegalStateException(
                    "Loan has already been closed.");
        }

        returnDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Loan ID: " + loanId
                + ", Book: " + book.getName()
                + ", Reader: " + reader.getName()
                + ", Borrow Date: " + borrowDate
                + ", Return Date: "
                + (returnDate == null ? "Not returned" : returnDate);
    }
}
