package Person;

//Making the Initial Customer
public class Customer extends Person {
    private int custNo;

    public Customer(int custNo, String firstName, String lastName, String email, String address) {
        super(firstName, lastName, email, address);
        this.custNo = custNo;
    }

    public int getCustNo() {
        return custNo;
    }
}
