package Models;
import java.util.ArrayList;

public class ProjectManager extends User{
    private String phoneNo;
    private String additionalAccount;
//    private ArrayList<String> customerList;
//    private ArrayList<String> BookingDetailsList;
//    private ArrayList<String> ServiceProviderList;
    
    public ProjectManager(String id, String name,String email,String password, String phoneNo,String additionalAccount){
        super(id, name, email, password);
        this.phoneNo=phoneNo;
        this.additionalAccount=additionalAccount;
//        this.customerList=new ArrayList<>();
//        this.ServiceProviderList=new ArrayList<>();
//        this.BookingDetailsList=new ArrayList<>();
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
}










//    public void ReceiveRequist(String Requist){
//        System.out.println("Received Requist"+Requist);
//    }
//    public boolean CheckAvailability(String service){
//        for (serviceprovider pr ovider:.ServiceProviderList ){
//            if (provider.hasservice(service)){
//                System.out.println("service found with provider :"+provider.getprovidername);
//            }
//            System.out.println("service not found");
//        }
//        return true;
//    }
//    public void receiveBillDetails(String billDetails) {
//        System.out.println("Received bill details: " + billDetails);
//    }
//    public void ReceiveBookingDetails(String BookingDetails){
//        BookingDetailsList.add(BookingDetails);
//        System.out.println("Booking details added"+BookingDetails);
//    }
//    public void setCustomerList(ArrayList<String>customer){
//        this.customerList=customer;
//    }
//    public void sendChanges(String changes) {
//        System.out.println("Sent changes to customer: " + changes);
//    }
//    public void contactCustomer(String customer) {
//        System.out.println("Contacted customer: " + customer);
//    }
//    public void receiveAvailability(String service, boolean isAvailable) {
//        if (isAvailable) {
//            System.out.println("Service " + service + " is available.");
//        } else {
//            System.out.println("Service " + service + " is not available.");
//        }
//    }
//    public void EditBookingDetails(int Bookingindex,String updatedDetails){
//        if(Bookingindex>=0&&Bookingindex<BookingDetailsList.size()){
//            String oldDetails = BookingDetailsList.get(Bookingindex);
//            BookingDetailsList.set(Bookingindex,updatedDetails);
//            System.out.println("Booking updated from: " + oldDetails + " to: " + updatedDetails);
//        }
//        else {
//
//            System.out.println("Invalid booking index. No changes made.");
//        }
//    }