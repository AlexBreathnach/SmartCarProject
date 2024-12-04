SmartCar Project - Car Rental System
Overview
Welcome to the SmartCar project
This is a simple car rental system where customers can sign up, book a car, and return it. Employees can manage vehicles, update rates, and list bookings, customers, and vehicles. It's all built using Java with object-oriented principles, so it’s modular and easy to expand.

Features
Customer Sign-Up: Customers can register by entering their details (name, email, address, etc.).
Book a Car: Customers can select from a list of available vehicles and book them for a specified duration and mileage.
Return a Car: Customers can return a vehicle and calculate the rental cost based on time and distance.
Employee Management: Employees can add new vehicles, change vehicle rates, and list all bookings, customers, and employees.
Exception Handling: Proper error handling to prevent crashes and make sure the user experience is smooth.
Additional Features:
Locations can be represented using enums (Limerick, Ennis, etc.).
Vehicle IDs are auto-generated when new vehicles are added.

Project Structure
Main.java – Entry point of the application (where the menus are displayed).
Vehicle/ – Contains all vehicle classes (Vehicle, SmartCity, SmartElectric, etc.).
Person/ – Contains Customer, Employee, and the base Person class.
Booking.java – Handles the booking process.

How the System Works
Customer Menu:
Sign Up: Customers enter their name, email, and other details to create an account. A customer number (custNo) is assigned.
Book a Car: Customers pick a car from a list and choose their pick-up and return times. It calculates rental fees based on time and distance.
Return a Car: Customers can return a vehicle and the system calculates the total cost, removing the booking from the system.
Employee Menu:
Manage Vehicles: Employees can add new vehicles and change their rates (hourly and daily).
List Bookings, Customers, and Vehicles: Employees can see all bookings, all customers, and details of all vehicles in the system.
List Employees: Displays a list of all employees with their details.
