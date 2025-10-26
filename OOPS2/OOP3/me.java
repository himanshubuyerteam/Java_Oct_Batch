package OOP3;

class Robot
{
    int id;
    static int count=0;
    int modelNo;
    String name;
    Robot(int id,int mno,String str)
    {
        id=id;
        modelNo=mno;
        name=str;
    }

    int getId()
    {
        return this.id;
    }

    static void print()
    {
        System.out.println("PRINTING");
    }
}
public class me {
    public static void main(String[] args) {
        Robot r1=new Robot(1,1,"RobotA");
        Robot r2=new Robot(2,2,"RobotB");
        System.out.println("count "+r1.count);
        r1.count++;
        r2.count++;
        System.out.println("count "+r1.count);
        System.out.println("count"+r2.count);
        // r1.getId();
        // Robot.print();
        // r1.print();

    }
}
