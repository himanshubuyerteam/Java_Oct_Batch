// package OOPS2;

// class BankAccount {
//     private String AccNo;
//     private String AccHolderName;
//     private double balance;
//     private String AccountType;
    
//     public BankAccount(String AccNo, String AccHolderName, double Amt, String AccountType) {
//         this.AccNo = AccNo;
//         this.AccHolderName = AccHolderName;
//         this.balance = Amt;
//         this.AccountType = AccountType;
//     }

//     public String getAccNo() {
//         return AccNo;
//     }

//     public void setAccNo(String accNo) {
//         AccNo = accNo;
//     }

//     private String getAccHolderName() {
//         return AccHolderName;
//     }

//     public void setAccHolderName(String accHolderName) {
//         AccHolderName = accHolderName;
//     }

//     public double getAmt() {
//         return balance;
//     }
//     public double withdraw(double amt)
//     {
//         if(amt>balance)
//             return -1;
//         return balance-amt;
//     }
//     public void setAmt(double amt) {
//         balance = amt;
//     }

//     public String getAccountType() {
//         return AccountType;
//     }

//     public void setAccountType(String accountType) {
//         AccountType = accountType;
//     }

// }

// public class BA
// {
//     public static void main(String[] args) {
//         BankAccount b1=new BankAccount("1234","RAHUL",10000,"Savings");
//         System.out.println(b1.getAccNo());
//         System.out.println(b1.getAccHolderName());
//         System.out.println(b1.getAmt());
//         System.out.println(b1.getAccountType());

//         b1.Amt=100000;
//         System.out.println(b1.getAmt());
//     }
// }
