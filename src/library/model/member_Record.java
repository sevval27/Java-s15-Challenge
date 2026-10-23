package library.model;

public class member_Record {

    private int memberId;
    private String type;
    private String dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public member_Record(
            int memberId,
            String type,
            String dateOfMembership,
            int maxBookLimit,
            String name,
            String address,
            String phoneNo) {

        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;

        this.noBooksIssued = 0;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void incBookIssued() {
        noBooksIssued++;
    }

    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }

    public void getMember() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Phone: " + phoneNo);
    }

    public void payBill(double amount) {
        System.out.println(
                name + " paid " + amount + " TL."
        );
    }
}
