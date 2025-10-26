package SOLIDS;
// Payment interface - defines the contract
interface Payment {
    void processPayment(double amount);
}

// Credit Card implementation
class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Connecting to credit card gateway...");
        System.out.println("Payment successful!");
    }
}

// PayPal implementation
class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Redirecting to PayPal...");
        System.out.println("Payment successful!");
    }
}

// Cryptocurrency implementation
class CryptoPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount);
        System.out.println("Connecting to blockchain...");
        System.out.println("Payment successful!");
    }
}

class CashPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cassh payment of $" + amount);
        System.out.println("Connecting to blockchain...");
        System.out.println("Payment successful!");
    }
}
public class OCP_AFTER {
    
}
