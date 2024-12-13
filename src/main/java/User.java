public class User {

    private String userId;
    private String name;
    private String Email;
    private String phoneNo;
    private String password;
    private String role;


    public User(String userId, String name, String Email, String phoneNo, String password, String role){
        this.userId = userId;
        this.name = name;
        this.Email = Email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.role = role;
    }

    public String getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return Email;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void displayInfo(){
        System.out.println("----------------------");
        System.out.println("User ID: " + userId);
        System.out.println("Name: " +name);
        System.out.println("Email: " +Email);
        System.out.println("Phone: " +phoneNo);
        System.out.println("Role: " +role);
    }

    public static User askrole(String userId, String name, String email, String phoneNo, String password){
        System.out.println("Enter the user role:(Customer, ProjectManger, ServiceProvider, admin): ");

        Scanner input = new Scanner(System.in);
        String role = input.nextLine().trim();

        switch(role.toLowerCase()){

            case "customer":
                return new Customer(userId, name, email, phoneNo, password,"Customer");
            case "projectmanger":
                return new ProjectManger(userId, name, email, phoneNo, password);
            case "serviceprovider":
                return new ServiceProvider(userId, name, email, phoneNo, password);
            case "admin":
                return new Admin(userId, name, email, phoneNo, password);
            default:
                System.out.println("Invalid Role!");
                return new User(userId, name, email, phoneNo, password, "User");
        }
    }

}
