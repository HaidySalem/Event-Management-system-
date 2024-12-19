public class Customer  extends User {
    private boolean single =true;//default value single
    private InsertDateAndTime birthDate;
    private InsertDateAndTime engagementDate;
    private InsertDateAndTime dateOfMarriage;
    private java.util.Date dateCreated;

    public String state {
        switch (single){
            case true
                return "single";
            case false
                return "in a relation";
        }
    }
    public Customer (String userId, String name, String Email, String phoneNo, String password, String role, boolean single, InsertDateAndTime birthDate, InsertDateAndTime engagementDate , InsertDateAndTime dateOfMarriage ,java.util.Date dateCreated){
        super();//envoking the super class constructor
        this.single=single;
        this.birthDate=birthDate;
        this.engagementDate=engagementDate;
        this.dateOfMarriage=dateOfMarriage;
        this.dateCreated= new java.util.Date();

    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public InsertDateAndTime getEngagementDate() {
        return engagementDate;
    }

    public void setEngagementDate(InsertDateAndTime engagementDate) {
        this.engagementDate = engagementDate;
    }

    public InsertDateAndTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(InsertDateAndTime birthDate) {
        this.birthDate = birthDate;
    }

    public InsertDateAndTime getDateOfMarriage() {
        return dateOfMarriage;
    }

    public void setDateOfMarriage(InsertDateAndTime dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }

    public String displayInfo(){
        return super.displayInfo() + "\n state : " + state  +"\n The birth Date : "+birthDate+
                "\n The date your account  created in : "+dateCreated;
    }
    public String displayMoreInfo(){
        if(single)
            return "";
        else
            return "\n The engagement Date : "+engagementDate+"\n The date of marriage : "+dateOfMarriage;
    }

}