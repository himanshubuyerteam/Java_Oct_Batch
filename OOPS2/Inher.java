package OOPS2;
class BankAccount
{
    private String accNo;
    private String holderName;
    private double balance;


    // private int a;
    // default int b;
    // protected int c;
    // public int d;

    BankAccount(String accNo,String holdername,double balance)
    {
        this.accNo=accNo;
        this.holderName=holdername;
        this.balance=balance;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
     
}
class SavingAccount extends BankAccount
{
    int ROI;
    SavingAccount(int ROI) {
        this.ROI = ROI;
    }

    
    
}

class CurrentAccount extends BankAccount
{
    int currentLimit;
    int salary;

    CurrentAccount(String accNo, String holderName, int currentLimit, int salary, double balance) {
        super(accNo, holderName, balance);
        this.currentLimit = currentLimit;
        this.salary = salary;
    }
}
public class Inher {
    public static void main(String[] args) {
        CurrentAccount ca1=new CurrentAccount("1234","RAHUL",5000,200,10000);
        ca1.getBalance();
        ca1.setBalance(1000);
        System.out.println(ca1.getBalance());
    }
}
