package library.model;

public class Faculty extends member_Record {

    public Faculty(
            int memberId,
            String dateOfMembership,
            int maxBookLimit,
            String name,
            String address,
            String phoneNo) {

        super(
            memberId,
            "Faculty",
            dateOfMembership,
            maxBookLimit,
            name,
            address,
            phoneNo
        );
    }
}