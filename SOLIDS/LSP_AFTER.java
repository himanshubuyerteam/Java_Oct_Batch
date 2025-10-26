package SOLIDS;
interface Payment {
    void processPayment();
    double getProcessingFee();
}

// Separate capability for refundable payments
interface RefundablePayment extends Payment {
    void refund();
}

// Payments that need balance validation
interface BalanceValidatedPayment extends Payment {
    boolean hasAvailableBalance();
}

// Credit card implementation - refundable
class CreditCardPayment implements RefundablePayment {
    private double amount;
    
    public CreditCardPayment(double amount) {
        this.amount = amount;
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of $" + amount);
    }
    
    @Override
    public void refund() {
        System.out.println("Refunding to credit card: $" + amount);
    }
    
    @Override
    public double getProcessingFee() {
        return amount * 0.02; // 2% fee
    }
}

// Cash implementation - NOT refundable
class CashPayment implements Payment {
    private double amount;
    
    public CashPayment(double amount) {
        this.amount = amount;
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment of $" + amount);
    }
    
    @Override
    public double getProcessingFee() {
        return 0; // No processing fee for cash
    }
    
    // Note: No refund() method - cash doesn't implement RefundablePayment
}
public class LSP_AFTER {
    
}
