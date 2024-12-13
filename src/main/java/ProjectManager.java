import java.util.ArrayList;

public class ProjectManager {
    private int PM_Id;
    private String PM_Name;
    private String PM_Email;
    private String PM_password;
    private String PM_MobileNumber;
    private String PM_AdditionalAccount;
    private ArrayList<String> customerList;
    private ArrayList<String> BookingDetailsList;
    private ArrayList<String> ServiceProviderList;
    
    public ProjectManager(int PM_Id,String PM_Name,String PM_Email,String PM_password,String PM_MobileNumber,String PM_AdditionalAccount){
        this.PM_Id=PM_Id;
        this.PM_Name=PM_Name;
        this.PM_Email=PM_Email;
        this.PM_password=PM_password;
        this.PM_MobileNumber=PM_MobileNumber;
        this.PM_AdditionalAccount=PM_AdditionalAccount;
        this.customerList=new ArrayList<>();
        this.ServiceProviderList=new ArrayList<>();
        this.BookingDetailsList=new ArrayList<>();
    }
    public boolean login(String Email,String password){
        return this.PM_Email.equals(Email)&&this.PM_password.equals(password);
    }
    public void ReceiveRequist(String Requist){
        System.out.println("Received Requist"+Requist);
    }
    public boolean CheckAvailability(String service){
        for (serviceprovider pr ovider:.ServiceProviderList ){
            if (provider.hasservice(service)){
                System.out.println("service found with provider :"+provider.getprovidername);
            }
            System.out.println("service not found");
        }
    }
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