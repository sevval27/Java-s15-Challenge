
package library.model;

public class Book {

    private final int bookId;
    private Author author;
    private Category category;
    private String name;
    private double price;
    private String status;
    private int edition;
    private String dateOfPurchase;

    public Book(
            int bookId,
            Author author,
            String name,
            double price,
            String status,
            int edition,
            String dateOfPurchase) {

        this(bookId, author, null, name, price, status,
                edition, dateOfPurchase);
    }

    public Book(
            int bookId,
            Author author,
            Category category,
            String name,
            double price,
            String status,
            int edition,
            String dateOfPurchase) {

        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative.");
        }

        this.bookId = bookId;
        this.author = author;
        this.category = category;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getBookId() {
        return bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative.");
        }
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(status);
    }

    public void display() {
        System.out.println("-------------------------");
        System.out.println("Book ID: " + bookId);
        System.out.println("Name: " + name);
        System.out.println("Author: "
                + (author == null ? "Unknown" : author.getName()));
        System.out.println("Category: "
                + (category == null ? "Uncategorized"
                : category.getName()));
        System.out.println("Price: " + price);
        System.out.println("Status: " + status);
        System.out.println("Edition: " + edition);
        System.out.println("Purchase Date: " + dateOfPurchase);
        System.out.println("-------------------------");
    }
}
