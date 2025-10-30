import java.util.ArrayList;
import java.util.List;

// ============================================================================
// ENUMS
// ============================================================================
enum CourseType { 
    ONLINE, 
    OFFLINE 
}

enum Specialization { 
    NODEJS, 
    JAVA 
}

// ============================================================================
// COURSE - Abstract base class
// ============================================================================
abstract class Course {
    private String courseId;
    private String courseName;
    private CourseType type;
    private Specialization specialization;
    
    public Course(String courseId, String courseName, CourseType type, Specialization specialization) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.type = type;
        this.specialization = specialization;
    }
    
    public String getCourseId() { 
        return courseId; 
    }
    
    public String getCourseName() { 
        return courseName; 
    }
    
    public CourseType getType() { 
        return type; 
    }
    
    public Specialization getSpecialization() { 
        return specialization; 
    }
    
    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Type: " + type);
        System.out.println("Specialization: " + specialization);
    }
}

// ============================================================================
// ONLINE COURSE
// ============================================================================
class OnlineCourse extends Course {
    private String platform;
    
    public OnlineCourse(String courseId, String courseName, Specialization specialization, String platform) {
        super(courseId, courseName, CourseType.ONLINE, specialization);
        this.platform = platform;
    }
    
    public String getPlatform() { 
        return platform; 
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
    }
}

// ============================================================================
// OFFLINE COURSE
// ============================================================================
class OfflineCourse extends Course {
    private String location;
    
    public OfflineCourse(String courseId, String courseName, Specialization specialization, String location) {
        super(courseId, courseName, CourseType.OFFLINE, specialization);
        this.location = location;
    }
    
    public String getLocation() { 
        return location; 
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Location: " + location);
    }
}

// ============================================================================
// LEARNER - Abstract base class
// ============================================================================
abstract class Learner {
    private String learnerId;
    private String name;
    private Specialization specialization;
    private int xp;
    
    public Learner(String learnerId, String name, Specialization specialization) {
        this.learnerId = learnerId;
        this.name = name;
        this.specialization = specialization;
        this.xp = 0;
    }
    
    public String getLearnerId() { 
        return learnerId; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public Specialization getSpecialization() { 
        return specialization; 
    }
    
    public int getXp() { 
        return xp; 
    }
    
    public void setXp(int xp) { 
        this.xp = xp; 
    }
    
    public void displayDetails() {
        System.out.println("Learner ID: " + learnerId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("XP: " + xp);
    }
}

// ============================================================================
// NODEJS LEARNER
// ============================================================================
class NodeJSLearner extends Learner {
    public NodeJSLearner(String learnerId, String name) {
        super(learnerId, name, Specialization.NODEJS);
    }
}

// ============================================================================
// JAVA LEARNER
// ============================================================================
class JavaLearner extends Learner {
    public JavaLearner(String learnerId, String name) {
        super(learnerId, name, Specialization.JAVA);
    }
}

// ============================================================================
// INSTRUCTOR
// ============================================================================
class Instructor {
    private String instructorId;
    private String name;
    
    public Instructor(String instructorId, String name) {
        this.instructorId = instructorId;
        this.name = name;
    }
    
    public String getInstructorId() { 
        return instructorId; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public void displayDetails() {
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Name: " + name);
    }
}

// ============================================================================
// COHORT
// ============================================================================
class Cohort {
    private String cohortId;
    private String cohortName;
    private Course course;
    private Instructor instructor;
    private List<Learner> learners;
    
    public Cohort(String cohortId, String cohortName, Course course, Instructor instructor) {
        this.cohortId = cohortId;
        this.cohortName = cohortName;
        this.course = course;
        this.instructor = instructor;
        this.learners = new ArrayList<>();
    }
    
    public String getCohortId() {
        return cohortId;
    }
    
    public String getCohortName() {
        return cohortName;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public Instructor getInstructor() {
        return instructor;
    }
    
    public List<Learner> getLearners() {
        return learners;
    }
    
    public void addLearner(Learner learner) {
        learners.add(learner);
    }
    
    public double calculateAverageXP() {
        if (learners.isEmpty()) {
            return 0.0;
        }
        
        int total = 0;
        for (Learner learner : learners) {
            total += learner.getXp();
        }
        return (double) total / learners.size();
    }
    
    public void displayDetails() {
        System.out.println("\n========== COHORT DETAILS ==========");
        System.out.println("Cohort ID: " + cohortId);
        System.out.println("Cohort Name: " + cohortName);
        
        System.out.println("\n--- Course ---");
        course.displayDetails();
        
        System.out.println("\n--- Instructor ---");
        instructor.displayDetails();
        
        System.out.println("\n--- Learners (" + learners.size() + ") ---");
        for (Learner learner : learners) {
            System.out.println();
            learner.displayDetails();
        }
        
        System.out.println("\nAverage XP: " + calculateAverageXP());
        System.out.println("====================================\n");
    }
}

// ============================================================================
// MAIN CLASS
// ============================================================================
public class Pro {
    public static void main(String[] args) {
        System.out.println("=== AIRTRIBE LMS ===\n");
        
        // 1. Create courses (Online + Offline for NodeJS and Java)
        Course nodeOnline = new OnlineCourse("C001", "Node.js Online", Specialization.NODEJS, "Zoom");
        Course nodeOffline = new OfflineCourse("C002", "Node.js Offline", Specialization.NODEJS, "Bangalore");
        Course javaOnline = new OnlineCourse("C003", "Java Online", Specialization.JAVA, "Google Meet");
        Course javaOffline = new OfflineCourse("C004", "Java Offline", Specialization.JAVA, "Delhi");
        
        // 2. Create instructors
        Instructor instructor1 = new Instructor("I001", "Priya Sharma");
        Instructor instructor2 = new Instructor("I002", "Rahul Kumar");
        
        // 3. Create cohorts
        Cohort cohort1 = new Cohort("COH001", "NodeJS Batch 1", nodeOnline, instructor1);
        Cohort cohort2 = new Cohort("COH002", "Java Batch 1", javaOnline, instructor2);
        
        // 4. Create and enroll learners
        Learner learner1 = new NodeJSLearner("L001", "Amit");
        learner1.setXp(850);
        cohort1.addLearner(learner1);
        
        Learner learner2 = new NodeJSLearner("L002", "Sneha");
        learner2.setXp(920);
        cohort1.addLearner(learner2);
        
        Learner learner3 = new JavaLearner("L003", "Rohan");
        learner3.setXp(1100);
        cohort2.addLearner(learner3);
        
        Learner learner4 = new JavaLearner("L004", "Priyanka");
        learner4.setXp(950);
        cohort2.addLearner(learner4);
        
        // 5. Display all details
        cohort1.displayDetails();
        cohort2.displayDetails();
        
        System.out.println("=== LMS Demo Complete ===");
    }
}