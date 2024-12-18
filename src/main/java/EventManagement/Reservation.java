/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;

/**
 *
 * @author ASUS
 */
public class Reservation {
    private static int idCounter = 1;
    private int reservationId;
    private User user;
    private EventDetails eventDetails;


    public Reservation(User user, EventDetails eventDetails) {
        this.reservationId = idCounter++;
        this.user = user;
        this.eventDetails = eventDetails;
        notifyCustomer();
    }

    public int getReservationId(){
        return this.reservationId;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void notifyCustomer() {
        System.out.println("Reservation created with ID: " + reservationId);
    }
}