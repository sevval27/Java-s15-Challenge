package library.model;
public class Librarian {

    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void search_book() {
        // kitap ara
        System.out.println("Kitap arama işlemi gerçekleştirildi.");
    }

    public void verify_member() {
        // üyeyi doğrula
        System.out.println("Üye doğrulama işlemi gerçekleştirildi.");
    }

    public void issue_book() {
        // kitap ver
        System.out.println("Kitap verme işlemi gerçekleştirildi.");
    }

    public void calculate_fine() {
        // gecikme cezası hesapla
        System.out.println("Gecikme cezası hesaplama işlemi gerçekleştirildi.");
    }

    public void create_bill() {
        // fatura oluştur
        System.out.println("Fatura oluşturma işlemi gerçekleştirildi.");
    }

    public void return_book() {
        // kitap teslim al
        System.out.println("Kitap teslim alma işlemi gerçekleştirildi.");
    }
}
