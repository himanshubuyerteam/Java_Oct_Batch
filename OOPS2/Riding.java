package OOPS2;

class A{
    void print()
    {
        System.out.println("Print function of A");
    }
}

class B extends A
{
    @Override
    void print()
    {
        System.out.println("Print function of B");
    }
}

class C extends A
{
    void print1()
    {
        System.out.println("Print function of C");
    }
}
public class Riding 
{
    public static void main(String[] args) {
        A a1 = new A();
        B b1=new B();
        A a2=new B();
        A a3=new C();
        a3.print();
        a1.print();
        b1.print();
        a2.print();
    }
}
