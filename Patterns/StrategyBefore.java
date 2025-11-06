package Patterns;

// Messy code with conditional logic
 class PaymentProcessor {
    private String paymentMethod;
    
    public PaymentProcessor(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void processPayment(double amount) {
        if (paymentMethod.equals("CREDIT_CARD")) {
            System.out.println("Processing credit card payment of $" + amount);
            System.out.println("Validating card number...");
            System.out.println("Checking card balance...");
            System.out.println("Payment successful!");
            
        } else if (paymentMethod.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment of $" + amount);
            System.out.println("Redirecting to PayPal...");
            System.out.println("Authenticating user...");
            System.out.println("Payment successful!");
            
        } else if (paymentMethod.equals("CRYPTOCURRENCY")) {
            System.out.println("Processing cryptocurrency payment of $" + amount);
            System.out.println("Connecting to blockchain...");
            System.out.println("Verifying wallet address...");
            System.out.println("Transaction confirmed!");
            
        } else {
            System.out.println("Invalid payment method!");
        }
    }
    
    // If you want to add a new payment method, you must modify this class
    // This violates the Open/Closed Principle
}

// Usage
public class StrategyBefore {
    public static void main(String[] args) {
        PaymentProcessor processor1 = new PaymentProcessor("CREDIT_CARD");
        processor1.processPayment(100.0);
        
        // To change payment method, create new object
        PaymentProcessor processor2 = new PaymentProcessor("PAYPAL");
        processor2.processPayment(150.0);
    }
}