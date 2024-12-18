/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package first.eventmangmentsystem;

import first.eventmangmentsystem.files.FileHandler;
import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class EventMangmentSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------Sign Up---------");

        System.out.print("Enter User ID:");
        String userID = scanner.nextLine();

        System.out.print("Enter Name:");
        String name = scanner.nextLine();

        System.out.print("Enter Email:");
        String email = scanner.nextLine();

        System.out.print("Enter Password:");
        String password = scanner.nextLine();

        System.out.print("Enter Phone:");
        String phone = scanner.nextLine();

        User user = User.askRole(userID, name, email, phone, password);

//        String filename = "data.txt";
//        FileHandler.saveDataToFile(user, "NULL", filename);
//        FileHandler.loadDataFromFile(filename);
        
        System.out.println("----------Log In---------");

        System.out.print("Enter Email: ");
        String Cemail = scanner.nextLine();

        System.out.print("Enter password: ");
        String Cpassword = scanner.nextLine();
        System.out.println("");

        Customer customer = new Customer(userID, name, email, phone, password, "Customer");

        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            if ("Customer".equalsIgnoreCase(user.getRole())) {
                System.out.println("Login successful as Customer.");
                CustomerMenu((Customer) user, scanner);
            } else if ("Project Manager".equalsIgnoreCase(user.getRole())) {
                System.out.println("Login successful as Project Manager.");
                ProjectManagerMenu((ProjectManager) user, scanner);
            } else if("Admin".equalsIgnoreCase(user.getRole())) {
                System.out.println("Invalid user role.");
                 AdminMenu((Admin) user, scanner);
            }else{
                System.out.println("Invalid user role.");
            }
            
        } else {
            System.out.println("Invalid email or password. Exiting...");
        }


        scanner.close();
    }
//--------------------------------Customer Menu--------------------------------
    private static void CustomerMenu(Customer customer, Scanner scanner) {
        System.out.print("Enter Birth Date (DD MM YYYY): ");
        int birthDay = scanner.nextInt();
        int birthMonth = scanner.nextInt();
        int birthYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        customer.setBirthDate(new InsertDateAndTime(birthDay, birthMonth, birthYear));
        System.out.println("Birth date set successfully!");

        System.out.print("Are you single? (Y/N): ");
        String relationshipStatus = scanner.nextLine();
        if (relationshipStatus.equalsIgnoreCase("N")) {
            customer.setSingle(false);
            System.out.print("Enter Engagement Date (DD MM YYYY): ");
            int engageDay = scanner.nextInt();
            int engageMonth = scanner.nextInt();
            int engageYear = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            customer.setEngagementDate(new InsertDateAndTime(engageDay, engageMonth, engageYear));
            System.out.println("Engagement date set successfully!");
        } else {
            customer.setSingle(true);
            System.out.println("You are single.");
        }

        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Personal Info");
            System.out.println("2. View More Info");
            System.out.println("3. Contact Project Manager");
            System.out.println("4. Book an Event");
            System.out.println("5. Edit an Event");
            System.out.println("6. Pay Bill");
            System.out.println("7. Log Out");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(customer.displayInfo());
                    break;
                case 2:
                    System.out.println(customer.displayMoreInfo());
                    break;
                case 3:
                    System.out.print("Enter your message for the Project Manager: ");
                    String message = scanner.nextLine();
                    customer.contactProjectManager(message);
                    break;
                case 4:
                    System.out.print("Event Type:");
                    String EventType = scanner.nextLine();

                    System.out.print("Enter date(DD/MM/YYYY):");
                    String dateInput = scanner.nextLine();

                    String[] dateParts = dateInput.split("/");
                    int day = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int year = Integer.parseInt(dateParts[2]);

                    InsertDateAndTime date = new InsertDateAndTime(day, month, year);
                    String FormDate = date.displayTheDate();

                    System.out.println("Enter time(HH:MM):");
                    String time = scanner.nextLine();

                    System.out.print("Number of guests:");
                    int guestcount = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the venue:");
                    String venue = scanner.nextLine();

                    System.out.print("Is there any addtional services(Y/N):");
                    String ch = scanner.nextLine();
                    String[] addServ = null;

                    if (ch.equalsIgnoreCase("Y")) {
                        System.out.println("How many addtional services do you want? ");

                        int num = scanner.nextInt();
                        scanner.nextLine();
                        addServ = new String[num];

                        for (int i = 0; i < num; i++) {
                            System.out.print("Enter service " + (i + 1) + ":");
                            addServ[i] = scanner.nextLine();
                        }

                    } else if (ch.equalsIgnoreCase("N")) {
                        System.out.println("no addtional services added.");
                    } else {
                        System.out.println("Invalid input");
                    }

                    System.out.print("Enter Special Requests:");
                    String spReq = scanner.nextLine();
                    EventDetails event = new EventDetails(EventType, FormDate, time, guestcount, venue, addServ, spReq);
                    customer.bookEvent(event);
                    String filename = "data.txt";

                    // FileHandler.saveDataToFile(users, reservations, filename);
                    break;

                case 5:
                    System.out.print("Enter new Date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter new Place: ");
                    String newPlace = scanner.nextLine();
                    System.out.println(customer.editBooking(newDate, newPlace));
                    break;
                case 6:
                    System.out.print("Enter payment amount: ");
                    float payment = scanner.nextFloat();
                    System.out.println(customer.payBill(payment));
                    break;
                case 7:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    //---------------------------Project Manger Menu-----------------------------------------///
    private static void ProjectManagerMenu(ProjectManager projectManager, Scanner scanner) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Project Manager Menu ---");
            System.out.println("1. View Personal Info");
            System.out.println("2. Receive Booking Details");
            System.out.println("3. Edit Booking Details");
            System.out.println("4. Contact Customer");
            System.out.println("5. Receive Bill Details");
            System.out.println("6. Log Out");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(projectManager.displayInfo());
                    break;
                case 2:
                    System.out.print("Enter Booking Details: ");
                    String bookingDetails = scanner.nextLine();
                    projectManager.ReceiveBookingDetails(bookingDetails);
                    break;
                case 3:
                    System.out.print("Enter Booking Index to Edit: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Updated Booking Details: ");
                    String updatedDetails = scanner.nextLine();
                    projectManager.EditBookingDetails(index, updatedDetails);
                    break;
                case 4:
                    System.out.print("Enter Customer Name to Contact: ");
                    String customerName = scanner.nextLine();
                    projectManager.contactCustomer(customerName);
                    break;
                case 5:
                    System.out.print("Enter Bill Details: ");
                    String billDetails = scanner.nextLine();
                    projectManager.receiveBillDetails(billDetails);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    ///----------------------Admin menu-------------------------------------/////
    private static void AdminMenu(Admin admin, Scanner scanner) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Personal Info");
            System.out.println("2. Manage Users");
            System.out.println("3. Forward Request to Project Manager");
            System.out.println("4. Show Available Venues");
            System.out.println("5. Show Reserved Venues");
            System.out.println("6. Log Out");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(admin.displayInfo());
                    break;
                case 2:
                    manageUsers(admin, scanner);
                    break;
                case 3:
                    System.out.print("Enter Event Type to forward request: ");
                    String eventType = scanner.nextLine();
                    EventDetails eventDetails = new EventDetails(eventType, "12/12/2024", "18:00", 100, "Venue 1", null, "No special requests");
                    admin.forwardRequestToPM(eventDetails);
                    break;
                case 4:
                    System.out.print("Enter Date (DD/MM/YYYY): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Time (HH:MM): ");
                    String time = scanner.nextLine();
                    admin.showAvailableVenues(date, time);
                    break;
                case 5:
                    admin.showReservedVenues();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageUsers(Admin admin, Scanner scanner) {
        System.out.println("\n--- Manage Users ---");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. Update User");
        System.out.println("4. Back to Admin Menu");

        System.out.print("Choose an option: ");
        int userChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (userChoice) {
            case 1:
                System.out.print("Enter User ID: ");
                String userId = scanner.nextLine();
                System.out.print("Enter User Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter User Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter User Phone No: ");
                String phoneNo = scanner.nextLine();
                System.out.print("Enter User Password: ");
                String password = scanner.nextLine();
                User newUser = new User(userId, name, email, phoneNo, password, "Customer");
                admin.manageUsers(newUser, "add");
                break;
            case 2:
                System.out.print("Enter User ID to remove: ");
                String removeId = scanner.nextLine();
                User userToRemove = new User(removeId, "", "", "", "", "");
                admin.manageUsers(userToRemove, "remove");
                break;
            case 3:
                System.out.print("Enter User ID to update: ");
                String updateId = scanner.nextLine();
                System.out.print("Enter New User Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter New User Email: ");
                String newEmail = scanner.nextLine();
                System.out.print("Enter New User Phone No: ");
                String newPhoneNo = scanner.nextLine();
                System.out.print("Enter New User Password: ");
                String newPassword = scanner.nextLine();
                User updatedUser = new User(updateId, newName, newEmail, newPhoneNo, newPassword, "Customer");
                admin.manageUsers(updatedUser, "update");
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice. Returning to Admin Menu.");
        }
    }
         
//        FileHandler.loadDataFromFile(filename);
}
