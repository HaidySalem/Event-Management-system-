import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Customer {

    private final String name;
    private String engagementDate;
    private boolean single;
    private String email;
    private String password;
    private String mobileNumber;

    public Customer(String name, String Email, String Password, String mobileNumber){
        this.name = name;
        this.email=Email;
        this.password=Password;
        this.mobileNumber=mobileNumber;
    }

    public String getName() {
        return this.name;
    }

    public boolean setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }
    public String getEmail() {
        return email != null ? email : "Not Set";
    }

    public boolean setPassword(String password) {
        if (password.length() >= 6) {
            this.password = password;
            return true;
        } else {
            return false;
        }
    }
    public String getPassword() {
        return password != null ? password : "Not Set";
    }

    public String getEngagementDate() {
        return engagementDate != null ? engagementDate : "Not Set";
    }
    public boolean setEngagementDate(String date) {
        try {
            LocalDate.parse(date);
            this.engagementDate = date;
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean isSingle() {
        return single;
    }
    public void setSingle(boolean single) {
        this.single = single;
    }

    public void setPhone(String mobileNumber){
        this.mobileNumber=mobileNumber;
    }
    public String getmobileNumber(){
        return mobileNumber;
    }

    public void Edit-Booking(int newreserve-times){
        if(newreserve-times>0){
            this.reserve-times=newreserve-times;
        }
    }
}