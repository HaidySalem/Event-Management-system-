/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Admin extends User {
    
    private ArrayList<Reservation> reservations;
    private ArrayList<Venue> allVenues;

    public Admin(String userId, String name, String email, String phoneNo, String password, String role) {
        super(userId, name, email, phoneNo, password, "Admin");
        
        
        this.reservations = new ArrayList<>();
        this.allVenues = new ArrayList<>();
    }


    public void manageUsers(int userId, String action) {
        System.out.println(action + " user with ID: " + userId);
    }
    public void manageUsers(User user, String action) {
        ArrayList<User> users = new ArrayList<>();
        switch (action.toLowerCase()) {
            case "add":
                users.add(user);
                System.out.println("Added user with ID: " + user.getUserId());
                break;
            case "remove":
                users.removeIf(u -> u.getUserId().equals(user.getUserId()));
                System.out.println("Removed user with ID: " + user.getUserId());
                break;
            case "update":
                for (User u : users) {
                    if (u.getUserId().equals(user.getUserId())) {
                        u.setName(user.getName());
                        u.setEmail(user.getEmail());
                        u.setPhoneNo(user.getPhoneNo());
                        u.setPassword(user.getPassword());
                        u.setRole(user.getRole());
                        System.out.println("Updated user with ID: " + user.getUserId());
                    }
                }
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }

    public void forwardRequestToPM(EventDetails request) {
        System.out.println("Forwarding request to PM: " + request.ٌeventType);//event type in eventDetails class
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation added for venue: " + reservation.getEventDetails().getVenue() + ", Date: " + reservation.getEventDetails().getDate() + ", Time: " + reservation.getEventDetails().getTime());
    }

    public void showAvailableVenues(String date, String time) {
        System.out.println("\n--- Checking Available Venues for Date: " + date + ", Time: " + time + " ---");
        ArrayList<String> reservedVenues = new ArrayList<>();
        for (Reservation reservation : reservations) {
            EventDetails details = reservation.getEventDetails();
            if (details.getDate().equals(date) && details.getTime().equals(time) && !reservedVenues.contains(details.getVenue())) {
                reservedVenues.add(details.getVenue());
            }
        }
        System.out.println("Available Venues:");
        for (Venue venue : allVenues) {
            if (!reservedVenues.contains(venue)) {
                System.out.println("Venue: " + venue);
            }
        }
        System.out.println("-----------------------------------\n");

    }

    public void showReservedVenues() {
        System.out.println("\n--- Reserved Venues ---");

        if (reservations != null) {
            for (Reservation reservation : reservations) {
                EventDetails details = reservation.getEventDetails();
                System.out.printf("Venue: %s | Date: %s | Time: %s%n", details.getVenue(), details.getDate(), details.getTime());
            }
        } else {
            System.out.println("No reservations available.");
        }

        System.out.println("-----------------------------------\n");
    }
}

