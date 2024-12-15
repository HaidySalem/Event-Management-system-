package Models;

import java.util.ArrayList;

public class Admin extends User{
//    private ArrayList<Models.Reservation> reservations;
//    private ArrayList<Venue> allVenues;

    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password);
//        this.reservations = new ArrayList<>();
//        this.allVenues = new ArrayList<>();
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
}









//    public void manageUsers(int userId, String action) {
//        System.out.println(action + " user with ID: " + userId);
//    }
//    public void manageUsers(User user, String action) {
//        ArrayList<User> users = new ArrayList<>();
//        switch (action.toLowerCase()) {
//            case "add":
//                users.add(user);
//                System.out.println("Added user with ID: " + user.getUserId());
//                break;
//            case "remove":
//                users.removeIf(u -> u.getUserId().equals(user.getUserId()));
//                System.out.println("Removed user with ID: " + user.getUserId());
//                break;
//            case "update":
//                for (User u : users) {
//                    if (u.getUserId().equals(user.getUserId())) {
//                        u.setName(user.getName());
//                        u.setEmail(user.getEmail());
////                        u.setPhoneNo(user.getPhoneNo());
//                        u.setPassword(user.getPassword());
////                        u.setRole(user.getRole());
//                        System.out.println("Updated user with ID: " + user.getUserId());
//                    }
//                }
//                break;
//            default:
//                System.out.println("Unknown action: " + action);
//        }
//    }

//    public void forwardRequestToPM(Models.EventDetails request) {
//        System.out.println("Forwarding request to PM: " + request.eventType);
//    }
//
//    public void addReservation(Models.Reservation reservation) {
//        reservations.add(reservation);
//        System.out.println("Models.Reservation added for venue: " + reservation.getEventDetails().getVenue() + ", Date: " + reservation.getEventDetails().getDate() + ", Time: " + reservation.getEventDetails().getTime());
//    }

//    public void showAvailableVenues(String date, String time) {
//        System.out.println("\n--- Checking Available Venues for Date: " + date + ", Time: " + time + " ---");
//        ArrayList<String> reservedVenues = new ArrayList<>();
//        for (Models.Reservation reservation : reservations) {
//            Models.EventDetails details = reservation.getEventDetails();
//            if (details.getDate().equals(date) && details.getTime().equals(time) && !reservedVenues.contains(details.getVenue())) {
//                reservedVenues.add(details.getVenue());
//            }
//        }
//        System.out.println("Available Venues:");
//        for (Venue venue : allVenues) {
//            if (!reservedVenues.contains(venue)) {
//                System.out.println("Venue: " + venue);
//            }
//        }
//        System.out.println("-----------------------------------\n");
//
//    }

//    public void showReservedVenues() {
//        System.out.println("\n--- Reserved Venues ---");
//
//        if (reservations != null) {
//            for (Models.Reservation reservation : reservations) {
//                Models.EventDetails details = reservation.getEventDetails();
//                System.out.printf("Venue: %s | Date: %s | Time: %s%n", details.getVenue(), details.getDate(), details.getTime());
//            }
//        } else {
//            System.out.println("No reservations available.");
//        }
//
//        System.out.println("-----------------------------------\n");
//    }