/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */

public class User {

    private String userId;
    private String name;
    private String email; 
    private String phoneNo;
    private String password;
    private String role;

    // Constructor
    public User(String userId, String name, String email, String phoneNo, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Setters 
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) { // Basic validation
            this.email = email;
        } else {
            System.out.println("Invalid email format.");
        }
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo.matches("\\d{10}")) { // Ensures the phone number is 11 digits
            this.phoneNo = phoneNo;
        } else {
            System.out.println("Invalid phone number. Please enter a 11-digit number.");
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public String displayInfo(){
        return "\n----------------\n"+
                "User ID: " + userId+
                "\nName: " + name+
                "\nEmail: " + email+
                "\nPhone: " + phoneNo+
                "\nRole: "+ role;                    
    }


    // Create user roles
    public static User askRole(String userId, String name, String email, String phoneNo, String password) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the user role (Customer, ProjectManager, ServiceProvider, Admin): ");
        String role = input.nextLine().trim();

        switch (role.toLowerCase()) {
            case "customer":
                return new Customer(userId, name, email, phoneNo, password, role);
            case "projectmanager":
                return new ProjectManager(userId, name, email, phoneNo, password);
            case "serviceprovider":
                return new ServiceProvider(userId, name, email, phoneNo, password);
            case "admin":
                return new Admin(userId, name, email, phoneNo, password);
            default:
                System.out.println("Invalid Role! Defaulting to generic User.");
                return new User(userId, name, email, phoneNo, password, "User");
        }
    }
}

