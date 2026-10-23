
package library.model;

import java.time.LocalDateTime;

public class Invoice {

    private final int invoiceId;
    private final int loanId;
    private final String readerName;
    private final String bookName;
    private final String transactionType;
    private final double amount;
    private final LocalDateTime date;

    public Invoice(
            int invoiceId,
            int loanId,
            String readerName,
            String bookName,
            String transactionType,
            double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative.");
        }

        this.invoiceId = invoiceId;
        this.loanId = loanId;
        this.readerName = readerName;
        this.bookName = bookName;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getLoanId() {
        return loanId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void display() {
        System.out.println("-------------------------");
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Loan ID: " + loanId);
        System.out.println("Reader: " + readerName);
        System.out.println("Book: " + bookName);
        System.out.println("Transaction: " + transactionType);
        System.out.println("Amount: " + amount + " TL");
        System.out.println("Date: " + date);
        System.out.println("-------------------------");
    }
}
