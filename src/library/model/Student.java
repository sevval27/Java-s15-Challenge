package library.model;

public class Student extends member_Record {

    public Student(
            int memberId,
            String dateOfMembership,
            int maxBookLimit,
            String name,
            String address,
            String phoneNo) {

        super(
            memberId,
            "Student",
            dateOfMembership,
            maxBookLimit,
            name,
            address,
            phoneNo
        );
    }
}
            