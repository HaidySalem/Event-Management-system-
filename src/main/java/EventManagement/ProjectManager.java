/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;

/**
 *
 * @author ASUS
 */
import Models.InsertDateAndTime;
import Models.User;

import java.util.ArrayList;

public class ProjectManager extends User {
    //unnecessary
//    private String PM_Id;  
//    private String PM_Name;
//    private String PM_Email;
//    private String PM_password;
//    private String PM_MobileNumber;

    //necessary for sending requist to sp
    String eventType;
    InsertDateAndTime eventDate;
    int numberOfPeople;
    String specialRequirements;



    private String PM_AdditionalAccount;
    private ArrayList<String> customerList;
    private ArrayList<String> BookingDetailsList;
    private ArrayList<String> ServiceProviderList;
    
    public ProjectManager(String PM_Id, String PM_Name, String PM_Email, String PM_MobileNumber, String PM_password, String role){
        super(PM_Id, PM_Name, PM_Email, PM_MobileNumber, PM_password, "Project Manager");   //super class 
//        this.PM_Id=PM_Id;
//        this.PM_Name=PM_Name;
//        this.PM_Email=PM_Email;
//        this.PM_password=PM_password;
//        this.PM_MobileNumber=PM_MobileNumber;
        this.PM_AdditionalAccount=PM_AdditionalAccount;
        this.customerList=new ArrayList<>();
        this.ServiceProviderList=new ArrayList<>();
        this.BookingDetailsList=new ArrayList<>();
    }
    
    // updated log-in  
public boolean login(String enteredEmail, String enteredPassword) {
       
        if (getEmail().equals(enteredEmail) && getPassword().equals(enteredPassword)) {
            System.out.println("Login successful for Project Manger: " + getName());
            return true;
        } else {
            System.out.println("Invalid email or password. Login failed.");
            return false;
        }
    }

//the fn
public void ServiceRequest(String eventType, InsertDateAndTime eventDate, int numberOfPeople, String specialRequirements) {
    this.eventType = eventType;
    this.eventDate = eventDate;
    this.numberOfPeople = numberOfPeople;
    this.specialRequirements = specialRequirements;
}

    @Override
    public String toString() {
        return "Event Type: " + eventType + "\nEvent Date: " + eventDate +
                "\nNumber of People: " + numberOfPeople + "\nSpecial Requirements: " + specialRequirements;
    }
}

//public void ReceiveRequist(String Requist){
 ///blic boolean CheckAvailability(String service){
//        for (serviceproviderprovider:.ServiceProviderList ){
//            if (provider.hasservice(service)){
//                System.out.println("service found with provider :"+provider.getprovidername);
//            }
//            System.out.println("service not found");
//        }
//    }
public void receiveBillDetails(String billDetails) {
        System.out.println("Received bill details: " + billDetails);
    }


public void ReceiveBookingDetails(String BookingDetails){
        BookingDetailsList.add(BookingDetails);
        System.out.println("Booking details added"+BookingDetails);
    }


public void setCustomerList(ArrayList<String>customer){
        this.customerList=customer;
    }


public void sendChanges(String changes) {
        System.out.println("Sent changes to customer: " + changes);
    }


public void contactCustomer(String customer) {
        System.out.println("Contacted customer: " + customer);
    }


public void receiveAvailability(String service, boolean isAvailable) {
        if (isAvailable) {
            System.out.println("Service " + service + " is available.");
        } else {
            System.out.println("Service " + service + " is not available.");
        }
    }

public void EditBookingDetails(int Bookingindex,String updatedDetails){
        if(Bookingindex>=0&&Bookingindex<BookingDetailsList.size()){
            String oldDetails = BookingDetailsList.get(Bookingindex);
            BookingDetailsList.set(Bookingindex,updatedDetails);
            System.out.println("Booking updated from: " + oldDetails + " to: " + updatedDetails);
        }
        else {

            System.out.println("Invalid booking index. No changes made.");
        }
    }
}