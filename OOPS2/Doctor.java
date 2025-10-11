package OOPS2;
class DoctorClass
{
    public String doctorName;
    private double Salary;
    protected int age;
    int phoneNo;

    
    public int sum(int a)
    {
        return a;
    }
    public int sum(int a,int b)
    {
        return a+b;
    }
}

public class Doctor {
    public static void main(String[] args) {
        
        DoctorClass d1=new DoctorClass();
        d1.sum(1);
        d1.sum(1,2);
        d1.sum(1,2,3);


    }
}
