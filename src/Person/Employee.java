package Person;

public class Employee extends Person {
    private int empNo;

    public Employee(int empNo, String firstName, String lastName, String email, String address) {
        super(firstName, lastName, email, address);
        this.empNo = empNo;
    }

    public int getEmpNo() {
        return empNo;
    }
}
