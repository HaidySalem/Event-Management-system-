/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;
 import java.io.*;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class files {


class User {
    private String userId;
    private String name;
    private String email;
    private String password;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return userId + "," + name + "," + email + "," + password;
    }
}

class Admin extends User {
    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password);
    }
}

class EventDetails {
    private String venue;
    private String date;
    private String time;

    public EventDetails(String venue, String date, String time) {
        this.venue = venue;
        this.date = date;
        this.time = time;
    }

    public String getVenue() { return venue; }
    public String getDate() { return date; }
    public String getTime() { return time; }

    @Override
    public String toString() {
        return venue + "," + date + "," + time;
    }
}

class Reservation {
    private static int idCounter = 1;
    private int reservationId;
    private EventDetails eventDetails;

    public Reservation(EventDetails eventDetails) {
        this.reservationId = idCounter++;
        this.eventDetails = eventDetails;
    }

    public int getReservationId() { return reservationId; }
    public EventDetails getEventDetails() { return eventDetails; }

    @Override
    public String toString() {
        return reservationId + "," + eventDetails;
    }
}

class FileHandler {

    public static void saveDataToFile(List<User> users, List<Reservation> reservations, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Users:\n");
            for (User user : users) {
                writer.write(user.toString() + "\n");
            }

            writer.write("\nReservations:\n");
            for (Reservation reservation : reservations) {
                writer.write(reservation.toString() + "\n");
            }

            System.out.println("Data saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static void loadDataFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean readingUsers = false;
            boolean readingReservations = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("Users:")) {
                    readingUsers = true;
                    readingReservations = false;
                    continue;
                } else if (line.equals("Reservations:")) {
                    readingReservations = true;
                    readingUsers = false;
                    continue;
                }

                if (readingUsers) {
                    System.out.println("User: " + line);
                } else if (readingReservations) {
                    System.out.println("Reservation: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
}
}
