package Patterns;

// 1. Strategy Interface
 interface PaymentStrategy {
    void pay(double amount);
}

// 2. Concrete Strategy: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    
    public CreditCardPayment(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("Validating card details...");
        System.out.println("Checking card balance...");
        System.out.println("Payment successful via Credit Card!");
    }
    
    private String maskCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}

// 3. Concrete Strategy: PayPal Payment
 class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Email: " + email);
        System.out.println("Redirecting to PayPal...");
        System.out.println("Authenticating user...");
        System.out.println("Payment successful via PayPal!");
    }
}

// 4. Concrete Strategy: Cryptocurrency Payment
 class CryptoPayment implements PaymentStrategy {
    private String walletAddress;
    
    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount);
        System.out.println("Wallet Address: " + walletAddress);
        System.out.println("Connecting to blockchain network...");
        System.out.println("Verifying wallet address...");
        System.out.println("Broadcasting transaction...");
        System.out.println("Transaction confirmed on blockchain!");
    }
}

// 5. Context Class
 class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double totalAmount;
    
    public ShoppingCart() {
        this.totalAmount = 0.0;
    }
    
    public void addItem(double price) {
        totalAmount += price;
    }
    
    // Allows setting/changing strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method!");
            return;
        }
        
        System.out.println("\n--- Checkout Process ---");
        System.out.println("Total Amount: $" + totalAmount);
        paymentStrategy.pay(totalAmount);
        System.out.println("------------------------\n");
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
}

// 6. Client Code
public class StrategyAfter {
    public static void main(String[] args) {
        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(50.0);
        cart.addItem(30.0);
        cart.addItem(20.0);
        
        // Pay with Credit Card
        PaymentStrategy creditCard = new CreditCardPayment(
            "1234567812345678", 
            "123", 
            "12/25"
        );
        cart.setPaymentStrategy(creditCard);
        cart.checkout();
        
        // Create another cart
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(75.0);
        
        // Pay with PayPal
        PaymentStrategy paypal = new PayPalPayment(
            "user@example.com", 
            "securePassword123"
        );
        cart2.setPaymentStrategy(paypal);
        cart2.checkout();
        
        // Create another cart
        ShoppingCart cart3 = new ShoppingCart();
        cart3.addItem(200.0);
        
        // Pay with Cryptocurrency
        PaymentStrategy crypto = new CryptoPayment(
            "1A2B3C4D5E6F7G8H9I0J"
        );
        cart3.setPaymentStrategy(crypto);
        cart3.checkout();
        
        // Demonstrate dynamic strategy switching
        ShoppingCart cart4 = new ShoppingCart();
        cart4.addItem(100.0);
        
        System.out.println("=== Dynamic Strategy Switching ===");
        cart4.setPaymentStrategy(creditCard);
        System.out.println("Selected: Credit Card");
        
        // User changes mind...
        cart4.setPaymentStrategy(paypal);
        System.out.println("Changed to: PayPal");
        cart4.checkout();
    }
}