import java.util.Scanner;

public class ٌMain {

    public static void tester(){
        Scanner scanner = new Scanner(System.in);

        Customer customer = new Customer( "nour");
        System.out.println("Customer Details Setting Program");
        System.out.println("-------------------------------");


        System.out.print("Enter Engagement Date (YYYY-MM-DD): ");
        String engagementDate = scanner.nextLine();
        if (customer.setEngagementDate(engagementDate)) {
            System.out.println("Engagement date set successfully!");
        } else {
            System.out.println("Invalid engagement date format!");
        }

        System.out.print("Are you single? (true/false): ");
        boolean single = scanner.nextBoolean();
        customer.setSingle(single);

        scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        if (customer.setEmail(email)) {
            System.out.println("Email set successfully!");
        } else {
            System.out.println("Invalid email format!");
        }

        System.out.print("Enter Password (at least 6 characters): ");
        String password = scanner.nextLine();
        if (customer.setPassword(password)) {
            System.out.println("Password set successfully!");
        } else {
            System.out.println("Password must be at least 6 characters long!");
        }
        System.out.println("\nCustomer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Engagement Date: " + customer.getEngagementDate());
        System.out.println("Single: " + (customer.isSingle() ? "Yes" : "No"));
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Password: " + customer.getPassword());
    }

    public static void main(String[] args) {
        tester();
    }
}