package OOP3;


abstract class Employee{
    String name;
    Employee(String str)
    {
        name=str;
    }
    void attendance()
    {
        System.out.println("MARKING ATTEDANCE");
    }

    abstract void work(); 
}
class HR extends Employee{
    int id;
    HR(int id,String name)
    {
        super(name);
        this.id=id;
    }
    void work()
    {
        System.out.println("HR WORK");
    }
}
// class Engineer extends Employee{
//     void work()
//     {
//         System.out.println("ENGINEER WORK");
//     }
// }
public class AbsClass {
    public static void main(String[] args) {
        HR h1=new HR(100,"Supriya");
        h1.attendance();
        h1.work();
        // Engineer e1=new Engineer();
        // e1.attendance();
        // e1.work();
    }
}
