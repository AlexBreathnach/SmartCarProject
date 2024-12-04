import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
        String menu = """
            Customer Menu:
            1. Sign Up
            2. Book a Car
            3. Return a Car
            4. Return to Main Menu
            """;
        String choice = JOptionPane.showInputDialog(menu);

        if (choice == null) return;  // Handle case if user cancels

        switch (choice) {
            case "1" -> JOptionPane.showMessageDialog(null, "Sign up feature.");
            case "2" -> JOptionPane.showMessageDialog(null, "Book a car feature.");
            case "3" -> JOptionPane.showMessageDialog(null, "Return a car feature.");
            case "4" -> {
                return;  // Return to main menu
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid choice.");
        }
    }

    private static void signUp() {
        try {
            String firstName = JOptionPane.showInputDialog("Enter first name:");
            String lastName = JOptionPane.showInputDialog("Enter last name:");
            String email = JOptionPane.showInputDialog("Enter email:");
            String address = JOptionPane.showInputDialog("Enter address:");

            // Customer number (assuming a simple auto-increment based on list size)
            int custNo = customers.size() + 1;
            Customer customer = new Customer(custNo, firstName, lastName, email, address);
            customers.add(customer);

            JOptionPane.showMessageDialog(null, "Customer signed up successfully! Customer No: " + custNo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error during sign up: " + e.getMessage());
        }
    }

    private static void bookCar() {
        try {
            // Display list of available vehicles
            String vehicleList = "Available Vehicles:\n";
            for (int i = 0; i < fleet.size(); i++) {
                Vehicle vehicle = fleet.get(i);
                vehicleList += (i + 1) + ". " +
                        vehicle.getManufacturer() + " " + vehicle.getModel() + " (ID: " + vehicle.getId() + ")\n";
            }

            String selectedVehicleIndex = JOptionPane.showInputDialog(vehicleList + "\nSelect vehicle number:");
            int vehicleIndex = Integer.parseInt(selectedVehicleIndex) - 1;

            if (vehicleIndex < 0 || vehicleIndex >= fleet.size()) {
                throw new IllegalArgumentException("Invalid vehicle selection.");
            }
            Vehicle selectedVehicle = fleet.get(vehicleIndex);

            // Get customer number
            String custNumber = JOptionPane.showInputDialog("Enter your customer number:");
            int custNo = Integer.parseInt(custNumber);

            Customer customer = findCustomerById(custNo);

            // Booking details
            String pickUpDate = JOptionPane.showInputDialog("Enter pick-up date (yyyy-mm-dd):");
            String pickUpTime = JOptionPane.showInputDialog("Enter pick-up time (HH:mm):");
            String returnDate = JOptionPane.showInputDialog("Enter return date (yyyy-mm-dd):");
            String returnTime = JOptionPane.showInputDialog("Enter return time (HH:mm):");
            String pickUpLocation = JOptionPane.showInputDialog("Enter pick-up location:");

            // Create booking
            int bookingId = bookings.size() + 1;
            Booking newBooking = new Booking(bookingId, selectedVehicle.getId(), custNo,
                    LocalDate.parse(pickUpDate), LocalTime.parse(pickUpTime),
                    LocalDate.parse(returnDate), LocalTime.parse(returnTime), pickUpLocation);

            bookings.add(newBooking);
            JOptionPane.showMessageDialog(null, "Booking created successfully! Booking ID: " + bookingId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error during car booking: " + e.getMessage());
        }
    }

    private static Customer findCustomerById(int custNo) throws IllegalArgumentException {
        for (Customer customer : customers) {
            if (customer.getCustNo() == custNo) {
                return customer;
            }
        }
        throw new IllegalArgumentException("Customer not found.");
    }

    private static void returnCar() {
        try {
            String bookingIdInput = JOptionPane.showInputDialog("Enter booking ID:");
            int bookingId = Integer.parseInt(bookingIdInput);

            Booking booking = findBookingById(bookingId);

            Vehicle vehicle = findVehicleById(booking.getVehicleId());

            // Calculate charges
            long hours = java.time.Duration.between(booking.getPickUpTime(), booking.getReturnTime()).toHours();
            double distance = Double.parseDouble(JOptionPane.showInputDialog("Enter distance traveled (km):"));
            double totalCost = vehicle.calculateRate((int) hours, distance);

            JOptionPane.showMessageDialog(null, "Car returned successfully! Total cost: €" + totalCost);

            // Remove booking (assuming a return ends the booking)
            bookings.remove(booking);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error during car return: " + e.getMessage());
        }
    }

    private static Booking findBookingById(int bookingId) throws IllegalArgumentException {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        throw new IllegalArgumentException("Booking not found.");
    }

    private static Vehicle findVehicleById(int vehicleId) throws IllegalArgumentException {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId() == vehicleId) {
                return vehicle;
            }
        }
        throw new IllegalArgumentException("Vehicle not found.");
    }

    private static void employeeMenu() {
        while (true) {
            String menu = """
            Employee Menu:
            1. Add Vehicle
            2. List All Bookings
            3. List All Customers
            4. List All Vehicles
            5. List All Employees
            6. Return to Main Menu
            """;

            String choice = JOptionPane.showInputDialog(menu);
            if (choice == null || choice.equals("7")) break; // Exit to the main menu

            try {
                switch (choice) {
                    case "1" -> addVehicle();
                    case "2" -> listBookings();
                    case "3" -> listCustomers();
                    case "4" -> listVehicles();
                    case "5" -> listEmployees();
                    default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    private static void addVehicle() {
        try {
            String vehicleType = JOptionPane.showInputDialog("Enter vehicle type (SmartCity, SmartTripper, SmartElectric, SmartVan):");
            String regNo = JOptionPane.showInputDialog("Enter registration number:");
            String manufacturer = JOptionPane.showInputDialog("Enter manufacturer:");
            String model = JOptionPane.showInputDialog("Enter model:");
            String regDate = JOptionPane.showInputDialog("Enter registration date (yyyy-mm-dd):");
            String location = JOptionPane.showInputDialog("Enter location (e.g., Limerick, Ennis, etc.):");

            int id = fleet.size() + 1; // Auto-generate ID

            switch (vehicleType.toLowerCase()) {
                case "smartcity" -> fleet.add(new SmartCity(id, regNo, manufacturer, model, LocalDate.parse(regDate), location, 1.2, 150));
                case "smarttripper" -> fleet.add(new SmartTripper(id, regNo, manufacturer, model, LocalDate.parse(regDate), location, 1.6, 180));
                case "smartelectric" -> fleet.add(new SmartElectric(id, regNo, manufacturer, model, LocalDate.parse(regDate), location, 77.4, 300));
                case "smartvan" -> fleet.add(new SmartVan(id, regNo, manufacturer, model, LocalDate.parse(regDate), location, 2.2, 200));
                default -> throw new IllegalArgumentException("Invalid vehicle type.");
            }

            JOptionPane.showMessageDialog(null, "Vehicle added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void listBookings() {
        //Initialisation
        String bookingList = "Bookings:\n";

        //Iterate through the list
        for (Booking b : bookings) {
            bookingList += "Booking ID: " + b.getBookingId() + //Unique Booking Id
                    ", Vehicle ID: " + b.getVehicleId() + // Vehicle ID
                    ", Customer No: " + b.getCustNo() + //Customer Number
                    ", Pick-Up: " + b.getPickUpDate() + " " + b.getPickUpTime() + //Pick-up date + Time
                    ", Return: " + b.getReturnDate() + " " + b.getReturnTime() + //Return date + Time
                    ", Location: " + b.getPickUpLocation() + "\n"; //Pickup Location
        }
        JOptionPane.showMessageDialog(null, bookingList);
    }

    private static void listCustomers() {
        String customerList = "Customers:\n";
        for (Customer c : customers) {
            customerList += "Customer No: " + c.getCustNo() +
                    ", Name: " + c.getFirstName() + " " + c.getLastName() +
                    ", Email: " + c.getEmail() +
                    ", Address: " + c.getAddress() + "\n";
        }
        JOptionPane.showMessageDialog(null, customerList);
    }

    private static void listVehicles() {
        String vehicleList = "Fleet:\n";
        for (Vehicle v : fleet) {
            vehicleList += "Vehicle ID: " + v.getId() +
                    ", Type: " + v.getClass().getSimpleName() +
                    ", Manufacturer: " + v.getManufacturer() +
                    ", Model: " + v.getModel() +
                    ", Location: " + v.getLocation() + "\n";
        }
        JOptionPane.showMessageDialog(null, vehicleList);
    }

    private static void listEmployees() {
        String employeeList = "Employees:\n";
        for (Employee e : employees) {
            employeeList += "Employee No: " + e.getEmpNo() +
                    ", Name: " + e.getFirstName() + " " + e.getLastName() +
                    ", Email: " + e.getEmail() +
                    ", Address: " + e.getAddress() + "\n";
        }
        JOptionPane.showMessageDialog(null, employeeList);
    }




}
