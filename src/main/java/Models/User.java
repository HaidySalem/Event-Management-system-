package Models;
import java.util.Scanner;

public class User {

    private String userId;
    private String name;
    private String email;
    private String password;
//    private String role;
//    private String phoneNo;

    // Constructor
    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
//        this.role = role;
    }

    // Getters
    public String getId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) { // Basic validation
            this.email = email;
        } else {
            System.out.println("Invalid email format.");
        }
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    
    public String displayInfo(){
        return "\n----------------\n"+
                "User ID: " + userId+
                "\nName: " + name+
                "\nEmail: " + email+
//                "\nPhone: " + phoneNo+
//                "\nRole: "+ role;
                "";
    }
}











// Create user roles
//    public static User askRole(String userId, String name, String email, String phoneNo, String password) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the user role (Models.Customer, Models.ProjectManager, ServiceProvider, Models.Admin): ");
//        String role = input.nextLine().trim();
//
//        switch (role.toLowerCase()) {
//            case "customer":
//                return new Customer(userId, name, email, phoneNo, password, role);
//            case "projectmanager":
//                return new Models.ProjectManager(userId, name, email, phoneNo, password);
//            case "serviceprovider":
//                return new ServiceProvider(userId, name, email, phoneNo, password);
//            case "admin":
//                return new Admin(userId, name, email, phoneNo, password);
//            default:
//                System.out.println("Invalid Role! Defaulting to generic User.");
//                return new User(userId, name, email, phoneNo, password, "User");
//        }
//    }
