package SOLIDS;
interface Worker {
    void work();
    void eat();
    void sleep();
    void attendMeeting();
}

// Human worker - needs all methods
class HumanWorker implements Worker {
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

// Robot worker - forced to implement methods it doesn't need
class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
    
    @Override
    public void eat() {
        // Robots don't eat! Forced to provide empty implementation
        throw new UnsupportedOperationException("Robots don't eat");
    }
    
    @Override
    public void sleep() {
        // Robots don't sleep! Forced to provide empty implementation
        throw new UnsupportedOperationException("Robots don't sleep");
    }
    
    @Override
    public void attendMeeting() {
        // Some robots don't attend meetings
        throw new UnsupportedOperationException("Robots don't attend meetings");
    }
}
public class ISP_BEFORE {
    
}
