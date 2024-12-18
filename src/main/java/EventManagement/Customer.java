/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
package first.eventmangmentsystem;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class Customer extends User {
    
    private String date;
    private String place;
    private static float price=1000;
    private String lastEditDate; 
    private String lastEditPlace; 
    private String previousDate; 
    private String previousPlace; 
    private boolean single =true;//default value single
    private InsertDateAndTime birthDate;
    private InsertDateAndTime engagementDate;
    private InsertDateAndTime dateOfMarriage;
    private java.util.Date dateCreated;
    private ArrayList<String> reserve_times;
    
    

    public Customer (String userId, String name, String Email, String phoneNo, String password,String role){
        super(userId, name, Email, phoneNo, password, "Customer");//envoking the super class constructor
        
        this.single=single;
        this.birthDate=birthDate;
        this.engagementDate=engagementDate;
        this.dateOfMarriage=dateOfMarriage;
        this.dateCreated = new java.util.Date();
    }
    
public String state() {
        if (single) {
            return "single";
        } else {
            return "in a relationship";
        }
    }
public boolean isSingle() {
        return single;
    }

public void setSingle(boolean single) {
        this.single = single;
    }

public InsertDateAndTime getEngagementDate() {
        return engagementDate;
    }

public void setEngagementDate(InsertDateAndTime engagementDate) {
        this.engagementDate = engagementDate;
    }

public InsertDateAndTime getBirthDate() {
        return birthDate;
    }

public void setBirthDate(InsertDateAndTime birthDate) {
        this.birthDate = birthDate;
    }

public InsertDateAndTime getDateOfMarriage() {
        return dateOfMarriage;
    }

public void setDateOfMarriage(InsertDateAndTime dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }

public String displayInfo(){
        return super.displayInfo() + "\n state : " +  state() +"\n The birth Date : "+birthDate+
                "\n The date your account  created in : "+dateCreated;
    }
    public String displayMoreInfo(){
        if(single)
            return "";
        else
            return "\n The engagement Date : "+engagementDate+"\n The date of marriage : "+dateOfMarriage;
    }
   
    
    
public String booking(String date, String place) {
        if (date == null && place == null && date.isEmpty() && place.isEmpty()) {
            return "Error: Date and place cannot be empty.";
        }

        if (this.date != null && this.place != null) {
            this.previousDate = this.date;
            this.previousPlace = this.place;
        }

        this.date = date;
        this.place = place;

        this.lastEditDate = date;
        this.lastEditPlace = place;

        return "Booking successfully made. Previous booking: Date - " + previousDate + ", Place - " + previousPlace +
               ". New booking: Date - " + date + ", Place - " + place;
    }

   
public String editBooking(String newDate, String newPlace) {
        if (newDate == null && newPlace == null && newDate.isEmpty() && newPlace.isEmpty()) {
            return "Error: Date and place cannot be empty.";
        }

        if (newDate.equals(this.date) && newPlace.equals(this.place)) {
            return "Error: No changes made. The new date and place are the same as the current ones.";
        }

        String oldDate = this.date;
        String oldPlace = this.place;

        this.date = newDate;
        this.place = newPlace;

        this.lastEditDate = oldDate + " -> " + newDate;
        this.lastEditPlace = oldPlace + " -> " + newPlace;

        return "Booking successfully updated. Old details: Date - " + oldDate + ", Place - " + oldPlace + 
               ". New details: Date - " + newDate + ", Place - " + newPlace;
    }


    public String payBill(float payment) {
        if (this.price == payment) {
            return "Success: Bill paid.";
        } else {
            return "Error: Please enter the correct price.";
        }
    }

    public float calculateTotalBill() {
        return this.price;  
    }

    
    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public float getPrice() {
        return price;
    }

    public String getLastEditDetails() {
        return "Last edited details: Date - " + this.lastEditDate + ", Place - " + this.lastEditPlace;
    }

  
    public String getPreviousBookingDetails() {
        return "Previous booking: Date - " + this.previousDate + ", Place - " + this.previousPlace;
    }

   
//public void EditBooking(ArrayList newreserve_times){
//        if(newreserve_times > 0){
//            this.reserve_times = newreserve_times;
//        }
//}
    // Method to book an event
public void bookEvent(EventDetails eventDetails) {
        if (eventDetails == null) {
            System.out.println("Event details cannot be empty.");
        } else {
            System.out.println("Booking event for " + getName() + ": " + eventDetails);
        }
    }

    // Method to pay the bill
public void payBill(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            System.out.println(getName() + " has paid a bill of $" + amount);
        }
    }

    // Method to log in
public boolean login(String enteredEmail, String enteredPassword) {
       

        if (getEmail().equals(enteredEmail) && getPassword().equals(enteredPassword)) {
            System.out.println("Login successful for customer: " + getName());
            return true;
        } else {
            System.out.println("Invalid email or password. Login failed.");
            return false;
        }
    }

    // Method to contact the project manager
public void contactProjectManager(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("Message cannot be empty.");
        } else {
            System.out.println("Customer " + getName() + " sent a message to the Project Manager: " + message);
        }
    }

//public class FileHandler {
//
//    public static void saveUsersToFile(ArrayList<User> users, String filename) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            for (User user : users) {
//                writer.write(user.getUserId() + "," + user.getName() + "," + user.getEmail() + "," + user.getPassword());
//                writer.newLine();
//            }
//            System.out.println("Users saved to file.");
//        } catch (IOException e) {
//            System.out.println("Error saving users: " + e.getMessage());
//        }
//    }
//
//    public static ArrayList<User> loadUsersFromFile(String filename) {
//        ArrayList<User> users = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] userData = line.split(",");
//                String userId = userData[0];
//                String name = userData[1];
//                String email = userData[2];
//                String phoneNo = userData[3];
//                String password = userData[4];
//                String role = userData[5];
//                users.add(new User(userId, name, email, phoneNo, password, role));
//            }
//        } catch (IOException e) {
//            System.out.println("Error loading users: " + e.getMessage());
//        }
//        return users;
//    }
//}
}