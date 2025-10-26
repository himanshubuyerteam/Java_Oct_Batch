package SOLIDS;

class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Responsibility 1: User data management
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Responsibility 2: Email validation
    public boolean isValidEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    // Responsibility 3: Database operations
    public void saveToDatabase() {
        System.out.println("Connecting to database...");
        System.out.println("Saving user: " + name + " with email: " + email);
        System.out.println("User saved successfully!");
    }
    
    // Responsibility 4: Email sending
    public void sendWelcomeEmail() {
        System.out.println("Connecting to email server...");
        System.out.println("Sending welcome email to: " + email);
        System.out.println("Email sent successfully!");
    }
    
    // Responsibility 5: Report generation
    public String generateUserReport() {
        return "User Report\n" +
               "============\n" +
               "Name: " + name + "\n" +
               "Email: " + email + "\n";
    }
}
public class SRP_BEFORE {
    
}
