public class Customer extends Person {
    private int custNo;

    public Customer(String firstName, String lastName, String email, String address, int custNo) {
        super(firstName, lastName, email, address);
        this.custNo = custNo;
    }
}
