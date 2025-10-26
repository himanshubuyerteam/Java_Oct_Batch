package SOLIDS;
// Base class for all payment methods
class Payment {
    protected double amount;
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    public void processPayment() {
        System.out.println("Processing payment of $" + amount);
    }
    
    public void refund() {
        System.out.println("Refunding $" + amount);
    }
    
    public double getProcessingFee() {
        return amount * 0.02; // 2% fee
    }
}

class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of $" + amount);
    }
    
    @Override
    public void refund() {
        System.out.println("Refunding to credit card: $" + amount);
    }
}

class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment of $" + amount);
    }
    
    @Override
    public void refund() {
        // VIOLATION: Cash payments can't be refunded electronically!
        throw new UnsupportedOperationException("Cash payments cannot be refunded automatically!");
    }
    
    @Override
    public double getProcessingFee() {
        // VIOLATION: Cash has no processing fee
        return 0; // Changes expected behavior
    }
}


// Client code - expects all payments to behave consistently
class PaymentProcessor {
    public void processAndRefundIfNeeded(Payment payment, boolean needsRefund) {
        payment.processPayment();
        
        double fee = payment.getProcessingFee();
        System.out.println("Processing fee: $" + fee);
        
        if (needsRefund) {
            payment.refund(); // BREAKS with CashPayment!
        }
    }
}

// Main class to demonstrate the problem
public class LSP_BEFORE {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        
        // Works fine
        Payment creditCard = new CreditCardPayment(100.0);
        processor.processAndRefundIfNeeded(creditCard, true);
        
        System.out.println("\n---\n");
        
        // BREAKS! Throws exception
        Payment cash = new CashPayment(50.0);
        processor.processAndRefundIfNeeded(cash, true); // Runtime exception!
        
        System.out.println("\n---\n");
        
    
    }
}