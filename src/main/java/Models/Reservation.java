package Models;

public class Reservation {
    private static int idCounter = 1;
    private int reservationId;
//    private User user;
    private EventDetails eventDetails;


//    public Models.Reservation(User user, Models.EventDetails eventDetails) {
//        this.reservationId = idCounter++;
//        this.user = user;
//        this.eventDetails = eventDetails;
//        notifyCustomer();
//    }

    public int getReservationId(){
        return this.reservationId;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void notifyCustomer() {
        System.out.println("Models.Reservation created with ID: " + reservationId);
    }
}