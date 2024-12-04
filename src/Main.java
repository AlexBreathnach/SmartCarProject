import Person.Customer;
import Person.Employee;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Main {
    private static ArrayList<Vehicle> fleet = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        initializeDummyData();
        while (true) {
            String menu = """
                Select an option:
                1. Customer Menu
                2. Employee Menu
                3. Exit
                """;
            String choice = JOptionPane.showInputDialog(menu);

            switch (choice) {
                case "1" -> customerMenu();
                case "2" -> employeeMenu();
                case "3" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    private static void initializeDummyData() {
        // Add sample data for fleet, customers, and employees
    }

    private static void customerMenu() {
        // Handle customer actions
    }

    private static void employeeMenu() {
        // Handle employee actions
    }
}
