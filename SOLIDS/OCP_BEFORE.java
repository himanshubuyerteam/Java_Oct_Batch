package SOLIDS;

class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing credit card payment of $" + amount);
            // Credit card processing logic
            System.out.println("Connecting to credit card gateway...");
            System.out.println("Payment successful!");
        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment of $" + amount);
            // PayPal processing logic
            System.out.println("Redirecting to PayPal...");
            System.out.println("Payment successful!");
        } else if (paymentType.equals("CRYPTO")) {
            System.out.println("Processing cryptocurrency payment of $" + amount);
            // Crypto processing logic
            System.out.println("Connecting to blockchain...");
            System.out.println("Payment successful!");
        }
        // Every time we add a new payment method, we need to MODIFY this class
    }
}

// Usage
class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("CREDIT_CARD", 100.0);
        processor.processPayment("PAYPAL", 200.0);
        processor.processPayment("CRYPTO", 300.0);
    }
}
public class OCP_BEFORE {
    
}
