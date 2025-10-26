package SOLIDS;
// Responsibility 1: User data management ONLY
class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
}

// Responsibility 2: Email validation
class EmailValidator {
    public boolean isValid(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}

// Responsibility 3: Database operations
class UserRepository {
    public void save(User user) {
        System.out.println("Connecting to database...");
        System.out.println("Saving user: " + user.getName() + 
                         " with email: " + user.getEmail());
        System.out.println("User saved successfully!");
    }
    
    public User findByEmail(String email) {
        // Database retrieval logic
        return null; // placeholder
    }
}

// Responsibility 4: Email sending
class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Connecting to email server...");
        System.out.println("Sending welcome email to: " + user.getEmail());
        System.out.println("Email sent successfully!");
    }
}

// Responsibility 5: Report generation
class UserReportGenerator {
    public String generate(User user) {
        return "User Report\n" +
               "============\n" +
               "Name: " + user.getName() + "\n" +
               "Email: " + user.getEmail() + "\n";
    }
}

// Usage example
class Main {
    public static void main(String[] args) {
        // Create user
        User user = new User("John Doe", "john@example.com");
        
        // Validate email
        EmailValidator validator = new EmailValidator();
        if (validator.isValid(user.getEmail())) {
            // Save to database
            UserRepository repository = new UserRepository();
            repository.save(user);
            
            // Send welcome email
            EmailService emailService = new EmailService();
            emailService.sendWelcomeEmail(user);
            
            // Generate report
            UserReportGenerator reportGenerator = new UserReportGenerator();
            String report = reportGenerator.generate(user);
            System.out.println(report);
        }
    }
}

public class SRP_AFTER {
    
}
