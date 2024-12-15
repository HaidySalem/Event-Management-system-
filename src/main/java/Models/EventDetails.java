package Models;

public class EventDetails {
    private String eventType;
    private String date;
    private String time;
    private int guestCount;
    private String venue;
    private String[] additionalServices;
    private String specialRequests;

    public EventDetails(String eventType, String date, String time, int guestCount, String venue, String[] additionalServices, String specialRequests) {
        this.eventType = eventType;
        this.date = date;
        this.time = time;
        this.guestCount = guestCount;
        this.venue = venue;
        this.additionalServices = additionalServices;
        this.specialRequests = specialRequests;
    }

    public String getEventType(){
        return eventType;
    }
    public void setEventType(String eventType){
        this.eventType=eventType;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

    public String getTime(){
        return eventType;
    }
    public void setTIme(String time){
        this.time=time;
    }

    public int getGuestCount(){
        return guestCount;
    }
    public void setGuestCount(int guestCount){
        this.guestCount=guestCount;
    }

    public String getVenue(){
        return venue;
    }
    public void setVenue(String venue){
        this.venue=venue;
    }

    public String getSpecialRequests(){
        return specialRequests;
    }
    public void setSpecialRequests(String specialRequests){
        this.specialRequests=specialRequests;
    }

    public String[] getAdditionalServices(){
        return additionalServices;
    }
    public void setAdditionalServices(String[] additionalServices){
        this.additionalServices=additionalServices;
    }

    public boolean isGuestCountValid(){
        return guestCount >0;
    }

    public String displayEventDetails(){
        return String.format("Event Type: %s\nDate: %s\nTime: %s\nGuest Count: %d\nVenue: %s\nSpecial Requests: %s\n",
                eventType, date, time, guestCount, venue, specialRequests);
    }
}