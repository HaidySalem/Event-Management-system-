
import java.util.Date;
public class servese_provider extends User {

    public servese_provider(String userId, String name, String email, String phoneNo, String password, String role) {
        super();
    }

    public boolean login(String enteredEmail, String enteredPassword) {

        if (getEmail().equals(enteredEmail) && getPassword().equals(enteredPassword)) {
            System.out.println("Login successful for Project Manger: " + getName());
            return true;
        } else {
            System.out.println("Invalid email or password. Login failed.");
            return false;
        }
    }





        private String serviceName;
        private double serviceCost;
        private Date  date= new Date();
        // private double baseCost;
        //private double additionalCost;


        public  servese_provider () {

            this("no name");
            get_details();
        }

        public  servese_provider (String serviceName) {
            super();
            this.serviceName = serviceName;
        }
        void get_details(){
            System.out.println("service name a serviceCost =100");
            System.out.println("service name b serviceCost =200");
            System.out.println("service name c serviceCost =300");

        }


        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
            checkServiceCost();

        }
        void checkServiceCost(){

            if(serviceName=="a"){
                this.serviceCost=100;


            }
            else
            if(serviceName=="b"){
                this.serviceCost=200;


            }
            else
            if(serviceName=="c"){
                this.serviceCost=300;


            }
            else

                System.out.print("this service not avilable");

        }

        public double getServiceCost() {

            return serviceCost;
        }

        public Date getDate() {


            return date;
        }

    // Method to receive a service request from the PM
    public void receiveRequest(ServiceRequest request) {
        System.out.println(name + " has received the following service request:\n" + request);
    }


    // Method to check availability
    public boolean checkAvailability(ServiceRequest request) {
        // For simplicity, assume service is always available bec I have no thing to search on there is n date and time in reservation class
        System.out.println("Service is available" );
        return true;
    }


}
