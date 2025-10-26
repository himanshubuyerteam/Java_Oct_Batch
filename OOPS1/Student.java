package OOPS1;
class Person
{
    int marks;
    int studentId;
    String name;
    Person(int m,int s,String n)
    {
        marks=m;
        studentId=s;
        name=n;
    }
    Person(int m,int s)
    {
        marks=m;
        studentId=s;
    }
    Person(Person obj)
    {
        marks=obj.marks;
        studentId=obj.studentId;
        name=obj.name;
    }


    void setName(String str)
    {
        name=str;
    }
}
public class Student {
    public static void main(String[] args) {
        Person p1=new Person(100,101,"Arun");
        Person p2=p1;
        Person p3=new Person(p1);
        System.out.println(p1.marks);
        System.out.println(p2.marks);
        System.out.println(p3.marks);
        p1.setName("RAHUL");
        p2.marks=200;
        p3.marks=300;
        System.out.println(p1.marks);
        System.out.println(p3.marks);


    }
}
