package Patterns;

public class BuilderCode {
    class User
    {
        int rollNo;
        int id;
        int marks;
        User(int rollNo,int id,int marks)
        {
            this.id=id;
            this.rollNo=rollNo;
            this.marks=marks;
        }
        User(){}
        class UserBuilder
        {
            int rollNo;
            public UserBuilder setrollNo(int rollNo)
            {
                // this.rollNo=rollNo;
                this.rollNode=rollNo;
                setRolNo(rollNo);
                return this;
            }
            public User build()
            {
                User u=new User();
                u.setRollNode
                return u;
            }
        }

    }
    public static void main(String[] args) {
        User u =new user.UserBuilder()
                    .setrollNo(10)
                    .setId(20)
                    .setDep("Eng")
                    .build();
        

    }
}
