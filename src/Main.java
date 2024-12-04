import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

import Person.Person;
import Person.Employee;
import Person.Customer;

import Vehicle.Vehicle;
import Vehicle.Petrol;
import Vehicle.SmartCity;
import Vehicle.SmartElectric;
import Vehicle.SmartTripper;
import Vehicle.SmartVan;

public class Main {
    private static ArrayList<Vehicle> fleet = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        DummyData();
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

    private static void DummyData() {
        fleet.add(new SmartCity(1, "123-AB", "Nissan", "Micra", LocalDate.of(2023, 1, 1), "Limerick", 1.2, 150));
        fleet.add(new SmartTripper(2, "456-CD", "Skoda", "Scala", LocalDate.of(2023, 5, 10), "Ennis", 1.6, 180));
        fleet.add(new SmartElectric(3, "789-EF", "Kia", "EV6", LocalDate.of(2023, 3, 15), "Shannon", 77.4, 300));
        fleet.add(new SmartVan(4, "012-GH", "Ford", "Transit", LocalDate.of(2023, 8, 20), "Foynes", 2.2, 200));
    }


    private static void customerMenu() {
        customers.add(new Customer(1, "John", "Doe", "john.doe@example.com", "123 Main Street"));
        customers.add(new Customer(2, "Jane", "Smith", "jane.smith@example.com", "456 Elm Street"));

        employees.add(new Employee(1, "Alice", "Johnson", "alice.johnson@example.com", "789 Pine Avenue"));
        employees.add(new Employee(2, "Bob", "Williams", "bob.williams@example.com", "101 Maple Drive"));

    }

    private static void employeeMenu() {
        while (true) {
            String menu = """
            Employee Menu:
            1. Add Vehicle
            2. Update Rates
            3. List All Bookings
            4. List All Customers
            5. List All Vehicles
            6. List All Employees
            7. Return to Main Menu
            """;

            String choice = JOptionPane.showInputDialog(menu);
            if (choice == null || choice.equals("7")) break; // Exit to the main menu

            try {
                switch (choice) {
                    case "1" -> addVehicle();
                    case "2" -> updateRates();
                    case "3" -> listBookings();
                    case "4" -> listCustomers();
                    case "5" -> listVehicles();
                    case "6" -> listEmployees();
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

}
