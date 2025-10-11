// package OOPS2;

// public class ATM {


//     private String atmId;
    
//     public ATM(String atmId) {
//         this.atmId = atmId;
//     }

//     public void withdrawCash(String  accountNo, double amount) {
//         System.out.println("\n--- ATM Withdrawal Process ---");
//         System.out.println("ATM ID: " + atmId);
        
//         // All this complexity is HIDDEN from the user
//         // This is ABSTRACTION!
//         if (verifyAccount(account)) {
//             if (checkSufficientBalance(account, amount)) {
//                 if (checkATMCashAvailability(amount)) {
//                     deductAmount(account, amount);
//                     dispenseCash(amount);
//                     printReceipt(account, amount);
//                     updateTransactionLog(account, amount);
//                     System.out.println("Transaction Successful!");
//                 } else {
//                     System.out.println("ATM has insufficient cash!");
//                 }
//             } else {
//                 System.out.println("Insufficient balance!");
//             }
//         } else {
//             System.out.println("Account verification failed!");
//         }
//     }

//     public static void main(String[] args) {
//         withdrawCash("AccNo",500);
//     }
// }
