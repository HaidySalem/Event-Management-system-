/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package first.eventmangmentsystem;

import java.util.Scanner;

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

//       user.displayInfo();
        System.out.println("----------Log In---------");

        System.out.print("Enter Email: ");
        String Cemail = scanner.nextLine();

        System.out.print("Enter password: ");
        String Cpassword = scanner.nextLine();
        System.out.println("");

        Customer customer = new Customer(userID, name, email, phone, password, "Customer");

        if (customer.login(Cemail, Cpassword)) {

            System.out.print("Enter Birth Date (DD MM YYYY): ");
            int birthDay = scanner.nextInt();
            int birthMonth = scanner.nextInt();
            int birthYear = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            customer.setBirthDate(new InsertDateAndTime(birthDay, birthMonth, birthYear));
            System.out.println("Birth date set successfully!");

            // Prompt for Relationship Status
            System.out.print("Are you single? (Y/N): ");
            String relationshipStatus = scanner.nextLine();
            if (relationshipStatus.equalsIgnoreCase("N")) {
                customer.setSingle(false); // Not single

                // Prompt for Engagement Date if not single
                System.out.print("Enter Engagement Date (DD MM YYYY): ");
                int engageDay = scanner.nextInt();
                int engageMonth = scanner.nextInt();
                int engageYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                customer.setEngagementDate(new InsertDateAndTime(engageDay, engageMonth, engageYear));
                System.out.println("Engagement date set successfully!");
            } else {
                customer.setSingle(true); // Single
                System.out.println("You are single.");
            }

            // Menu Loop
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\n--- Menu ---");
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
                        System.out.print("\nEnter your message for the Project Manager: ");
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
        } else {
            System.out.println("Login failed. Please check your email and password.");
        }

        scanner.close();
    }
}
