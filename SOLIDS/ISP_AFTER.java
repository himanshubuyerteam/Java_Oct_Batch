package SOLIDS;
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

interface MeetingAttendable {
    void attendMeeting();
}

// Human worker implements only what it needs
class ImprovedHumanWorker implements Workable, Eatable, Sleepable, MeetingAttendable {
    @Override
    public void work() {
        System.out.println("Human is working");
    }
    
    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
    
    @Override
    public void sleep() {
        System.out.println("Human is sleeping");
    }
    
    @Override
    public void attendMeeting() {
        System.out.println("Human is attending meeting");
    }
}

// Robot worker implements only what it needs
class ImprovedRobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
    // No need to implement eat(), sleep(), or attendMeeting()
}

// Manager robot that can attend meetings
class ManagerRobotWorker implements Workable, MeetingAttendable {
    @Override
    public void work() {
        System.out.println("Manager Robot is working");
    }
    
    @Override
    public void attendMeeting() {
        System.out.println("Manager Robot is attending meeting");
    }
}
public class ISP_AFTER {
    
}
