package Models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer  extends User {
    private String phoneNo;
    private boolean state = true; //default value single = false, in relation = true
    private String birthDate;
    private String engagementDate;
    private String dateOfMarriage;
    private final String dateCreated;

    //    private InsertDateAndTime birthDate;
    //    private InsertDateAndTime engagementDate;
    //    private InsertDateAndTime dateOfMarriage;

    public Customer (String userId, String name, String Email, String phoneNo, String password, boolean single, String birthDate, String engagementDate , String dateOfMarriage){
        super(userId, name, Email, password); //envoking the super class constructor
        this.phoneNo = phoneNo;
        this.state=single;
        this.birthDate=birthDate;
        this.engagementDate=engagementDate;
        this.dateOfMarriage=dateOfMarriage;
        this.dateCreated = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String getId(){return super.getId();}
    @Override
    public String getName(){return super.getName();}
    @Override
    public String getEmail(){return super.getEmail();}
    @Override
    public String getPassword(){return super.getPassword();}
    @Override
    public void setEmail(String email) {super.setEmail(email);}
    @Override
    public void setPassword(String password) {super.setPassword(password);}
    @Override
    public void setName(String name) {super.setName(name);}


    public boolean getState(){return state;}
    public void setState(boolean single) {this.state = single;}

    public String getEngagementDate() {return engagementDate;}
    public void setEngagementDate(String engagementDate) {this.engagementDate = engagementDate;}

    public String getBirthDate() {return birthDate;}
    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

    public String getDateOfMarriage() {return dateOfMarriage;}
    public void setDateOfMarriage(String dateOfMarriage) {this.dateOfMarriage = dateOfMarriage;}

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        if (phoneNo.matches("\\d{10}")) { // Ensures the phone number is 11 digits
            this.phoneNo = phoneNo;
        } else {
            System.out.println("Invalid phone number. Please enter a 11-digit number.");
        }
    }

    public String displayInfo(){
        return super.displayInfo() + "\n state : " + state  +"\n The birth Date : "+birthDate+
                "\n The date your account  created in : "+dateCreated;
    }
}












//    public String displayMoreInfo(){
//        if(single)
//            return "";
//        else
//            return "\n The engagement Date : "+engagementDate+"\n The date of marriage : "+dateOfMarriage;
//    }

/// ///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package first.eventmangmentsystem;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.*;
//
///**
// *
// * @author ASUS
// */
//public class Models.Customer extends User {
//
//    private String date;
//    private String place;
//    private static float price=1000;
//    private String lastEditDate;
//    private String lastEditPlace;
//    private String previousDate;
//    private String previousPlace;
//    private boolean single =true;//default value single
//    private Models.InsertDateAndTime birthDate;
//    private Models.InsertDateAndTime engagementDate;
//    private Models.InsertDateAndTime dateOfMarriage;
//    private java.util.Date dateCreated;
//    private ArrayList<String> reserve_times;
//
//
//
//public String booking(String date, String place) {
//        if (date == null && place == null && date.isEmpty() && place.isEmpty()) {
//            return "Error: Date and place cannot be empty.";
//        }
//
//        if (this.date != null && this.place != null) {
//            this.previousDate = this.date;
//            this.previousPlace = this.place;
//        }
//
//        this.date = date;
//        this.place = place;
//
//        this.lastEditDate = date;
//        this.lastEditPlace = place;
//
//        return "Booking successfully made. Previous booking: Date - " + previousDate + ", Place - " + previousPlace +
//               ". New booking: Date - " + date + ", Place - " + place;
//    }
//
//
//public String editBooking(String newDate, String newPlace) {
//        if (newDate == null && newPlace == null && newDate.isEmpty() && newPlace.isEmpty()) {
//            return "Error: Date and place cannot be empty.";
//        }
//
//        if (newDate.equals(this.date) && newPlace.equals(this.place)) {
//            return "Error: No changes made. The new date and place are the same as the current ones.";
//        }
//
//        String oldDate = this.date;
//        String oldPlace = this.place;
//
//        this.date = newDate;
//        this.place = newPlace;
//
//        this.lastEditDate = oldDate + " -> " + newDate;
//        this.lastEditPlace = oldPlace + " -> " + newPlace;
//
//        return "Booking successfully updated. Old details: Date - " + oldDate + ", Place - " + oldPlace +
//               ". New details: Date - " + newDate + ", Place - " + newPlace;
//    }
//
//
//    public String payBill(float payment) {
//        if (this.price == payment) {
//            return "Success: Bill paid.";
//        } else {
//            return "Error: Please enter the correct price.";
//        }
//    }
//
//    public float calculateTotalBill() {
//        return this.price;
//    }
//
//
//    public String getDate() {
//        return date;
//    }
//
//    public String getPlace() {
//        return place;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public String getLastEditDetails() {
//        return "Last edited details: Date - " + this.lastEditDate + ", Place - " + this.lastEditPlace;
//    }
//
//
//    public String getPreviousBookingDetails() {
//        return "Previous booking: Date - " + this.previousDate + ", Place - " + this.previousPlace;
//    }
//
//
////public void EditBooking(ArrayList newreserve_times){
////        if(newreserve_times > 0){
////            this.reserve_times = newreserve_times;
////        }
////}
//    // Method to book an event
//public void bookEvent(Models.EventDetails eventDetails) {
//        if (eventDetails == null) {
//            System.out.println("Event details cannot be empty.");
//        } else {
//            System.out.println("Booking event for " + getName() + ": " + eventDetails);
//        }
//    }
//
//    // Method to pay the bill
//public void payBill(double amount) {
//        if (amount <= 0) {
//            System.out.println("Invalid amount. Please enter a positive value.");
//        } else {
//            System.out.println(getName() + " has paid a bill of $" + amount);
//        }
//    }
//
//    // Method to log in
//public boolean login(String enteredEmail, String enteredPassword) {
//
//
//        if (getEmail().equals(enteredEmail) && getPassword().equals(enteredPassword)) {
//            System.out.println("Login successful for customer: " + getName());
//            return true;
//        } else {
//            System.out.println("Invalid email or password. Login failed.");
//            return false;
//        }
//    }
//
//    // Method to contact the project manager
//public void contactProjectManager(String message) {
//        if (message == null || message.isEmpty()) {
//            System.out.println("Message cannot be empty.");
//        } else {
//            System.out.println("Models.Customer " + getName() + " sent a message to the Project Manager: " + message);
//        }
//    }
//}
//
