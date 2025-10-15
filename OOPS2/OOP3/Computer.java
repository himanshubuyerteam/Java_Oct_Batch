package OOP3;

import java.util.ArrayList;

interface kb
{
    int noOfKeys=10;
    void play();
    void type();
}
class wiredKeyBoard implements kb
{
    List<Integer>al=new ArrayList<>();
    public void type()
    {
        System.out.println("typing");
    }
    public void play()
    {
        System.out.println("playing");
    }
}
class Laptop
{
    kb keyboard;
    String name;
    int modelNo;
    Laptop(kb wkb)
    {
        keyboard=wkb;
    }
    void type()
    {
        keyboard.type();
    }

    int getKey()
    {
        return keyboard.noOfKeys;
    }
}
public class Computer {
    public static void main(String[] args) {
        Laptop l1=new Laptop(new wiredKeyBoard());
        l1.type();
        l1.getkey();
    }
}
