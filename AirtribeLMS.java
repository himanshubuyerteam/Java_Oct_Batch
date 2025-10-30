// ============================================================================
// INTERFACES - Following Interface Segregation Principle (ISP)
// ============================================================================

/**
 * Identifiable Interface
 * Purpose: Provides unique identification capability
 * ISP: Focused single responsibility - only ID management
 */
interface Identifiable {
    String getId();
}

/**
 * XPTrackable Interface
 * Purpose: Segregates XP functionality only for entities that need it
 * ISP: Clients that don't need XP won't depend on it
 */
interface XPTrackable {
    int getXP();
    void setXP(int xp);
}

/**
 * Displayable Interface
 * Purpose: Separates display concerns from business logic
 * SRP: Display logic is isolated
 */
interface Displayable {
    void displayDetails();
}

// ============================================================================
// ENUMERATIONS - Type Safety
// ============================================================================

enum CourseType {
    ONLINE, OFFLINE
}

enum CourseSpecialization {
    NODEJS, JAVA
}

// ============================================================================
// ABSTRACT COURSE CLASS - Abstraction & OCP
// ============================================================================

/**
 * Abstract Course Class
 * 
 * Design Rationale:
 * - Abstraction: Hides common course implementation details
 * - OCP: Open for extension (new course types), closed for modification
 * - Encapsulation: Private fields with controlled access
 * - Template: Defines structure for all courses
 */
abstract class Course implements Identifiable, Displayable {
    private final String courseId;
    private final String courseName;
    private final CourseSpecialization specialization;
    private final CourseType type;
    
    // Encapsulation: Constructor validates and initializes
    public Course(String courseId, String courseName, 
                  CourseSpecialization specialization, CourseType type) {
        if (courseId == null || courseId.trim().isEmpty()) {
            throw new IllegalArgumentException("Course ID cannot be empty");
        }
        this.courseId = courseId;
        this.courseName = courseName;
        this.specialization = specialization;
        this.type = type;
    }
    
    // Encapsulation: Controlled access via getters
    @Override
    public String getId() {
        return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public CourseSpecialization getSpecialization() {
        return specialization;
    }
    
    public CourseType getType() {
        return type;
    }
    
    // Polymorphism: Can be overridden by subclasses
    @Override
    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Specialization: " + specialization);
        System.out.println("Type: " + type);
    }
}

// ============================================================================
// CONCRETE COURSE CLASSES - Inheritance & LSP
// ============================================================================

/**
 * OnlineCourse Class
 * 
 * Design Rationale:
 * - Inheritance: Extends Course with online-specific features
 * - LSP: Can substitute Course without breaking functionality
 * - OCP: Extends without modifying parent
 */
class OnlineCourse extends Course {
    private String platformLink;
    
    public OnlineCourse(String courseId, String courseName, 
                       CourseSpecialization specialization, String platformLink) {
        super(courseId, courseName, specialization, CourseType.ONLINE);
        this.platformLink = platformLink;
    }
    
    public String getPlatformLink() {
        return platformLink;
    }
    
    // Polymorphism: Method overriding
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform Link: " + platformLink);
    }
}

/**
 * OfflineCourse Class
 * 
 * Design Rationale:
 * - Inheritance: Extends Course with offline-specific features
 * - LSP: Can substitute Course without breaking functionality
 */
class OfflineCourse extends Course {
    private String location;
    private String schedule;
    
    public OfflineCourse(String courseId, String courseName, 
                        CourseSpecialization specialization, 
                        String location, String schedule) {
        super(courseId, courseName, specialization, CourseType.OFFLINE);
        this.location = location;
        this.schedule = schedule;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getSchedule() {
        return schedule;
    }
    
    // Polymorphism: Method overriding
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Location: " + location);
        System.out.println("Schedule: " + schedule);
    }
}

// ============================================================================
// ABSTRACT LEARNER CLASS - Abstraction & Polymorphism
// ============================================================================

/**
 * Abstract Learner Class
 * 
 * Design Rationale:
 * - Abstraction: Common learner behavior
 * - Multiple Interfaces: Demonstrates ISP - implements only needed contracts
 * - OCP: Extensible for new learner types
 * - Encapsulation: Protected XP management
 */
abstract class Learner implements Identifiable, XPTrackable, Displayable {
    private final String learnerId;
    private final String name;
    private int xp;
    private final CourseSpecialization specialization;
    
    public Learner(String learnerId, String name, CourseSpecialization specialization) {
        if (learnerId == null || learnerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Learner ID cannot be empty");
        }
        this.learnerId = learnerId;
        this.name = name;
        this.xp = 0; // Default XP
        this.specialization = specialization;
    }
    
    @Override
    public String getId() {
        return learnerId;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int getXP() {
        return xp;
    }
    
    @Override
    public void setXP(int xp) {
        if (xp < 0) {
            throw new IllegalArgumentException("XP cannot be negative");
        }
        this.xp = xp;
    }
    
    public CourseSpecialization getSpecialization() {
        return specialization;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Learner ID: " + learnerId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("XP: " + xp);
    }
}

// ============================================================================
// CONCRETE LEARNER CLASSES - Inheritance & LSP
// ============================================================================

/**
 * NodeJSLearner Class
 * 
 * Design Rationale:
 * - Inheritance: Specializes Learner for Node.js
 * - LSP: Fully substitutable for Learner
 */
class NodeJSLearner extends Learner {
    public NodeJSLearner(String learnerId, String name) {
        super(learnerId, name, CourseSpecialization.NODEJS);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("=== Node.js Learner ===");
        super.displayDetails();
    }
}

/**
 * JavaLearner Class
 * 
 * Design Rationale:
 * - Inheritance: Specializes Learner for Java
 * - LSP: Fully substitutable for Learner
 */
class JavaLearner extends Learner {
    public JavaLearner(String learnerId, String name) {
        super(learnerId, name, CourseSpecialization.JAVA);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("=== Java Learner ===");
        super.displayDetails();
    }
}

// ============================================================================
// INSTRUCTOR CLASS - Single Responsibility
// ============================================================================

/**
 * Instructor Class
 * 
 * Design Rationale:
 * - SRP: Manages only instructor data
 * - Encapsulation: Private fields, public getters
 * - Simple entity without unnecessary complexity
 */
class Instructor implements Identifiable, Displayable {
    private final String instructorId;
    private final String name;
    
    public Instructor(String instructorId, String name) {
        if (instructorId == null || instructorId.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructor ID cannot be empty");
        }
        this.instructorId = instructorId;
        this.name = name;
    }
    
    @Override
    public String getId() {
        return instructorId;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Instructor Name: " + name);
    }
}

// ============================================================================
// COHORT CLASS - Composition & Business Logic
// ============================================================================

/**
 * Cohort Class
 * 
 * Design Rationale:
 * - Composition: Has-a relationship with Learners and Instructor
 * - DIP: Depends on Learner abstraction, not concrete implementations
 * - SRP: Manages cohort operations (enrollment, XP calculation)
 * - Encapsulation: Private collections with controlled access
 */
class Cohort implements Identifiable, Displayable {
    private final String cohortId;
    private final String cohortName;
    private final Course course;
    private final Instructor instructor;
    private final List<Learner> learners; // DIP: Depends on abstraction
    
    public Cohort(String cohortId, String cohortName, Course course, Instructor instructor) {
        if (cohortId == null || cohortId.trim().isEmpty()) {
            throw new IllegalArgumentException("Cohort ID cannot be empty");
        }
        this.cohortId = cohortId;
        this.cohortName = cohortName;
        this.course = course;
        this.instructor = instructor;
        this.learners = new ArrayList<>();
    }
    
    @Override
    public String getId() {
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
    
    // Encapsulation: Returns unmodifiable view
    public List<Learner> getLearners() {
        return new ArrayList<>(learners);
    }
    
    /**
     * Enrolls a learner with validation
     * Business Logic: Ensures learner specialization matches course
     */
    public void enrollLearner(Learner learner) {
        if (learner == null) {
            throw new IllegalArgumentException("Learner cannot be null");
        }
        
        // Validation: Specialization match
        if (!learner.getSpecialization().equals(course.getSpecialization())) {
            throw new IllegalArgumentException(
                "Learner specialization must match course specialization");
        }
        
        learners.add(learner);
        System.out.println("✓ Enrolled: " + learner.getName() + " to cohort " + cohortName);
    }
    
    /**
     * Calculates average XP using Learner abstraction
     * Demonstrates polymorphism and DIP
     */
    public double calculateAverageXP() {
        if (learners.isEmpty()) {
            return 0.0;
        }
        
        int totalXP = 0;
        for (Learner learner : learners) { // Polymorphism
            totalXP += learner.getXP();
        }
        
        return (double) totalXP / learners.size();
    }
    
    @Override
    public void displayDetails() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║           COHORT DETAILS                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Cohort ID: " + cohortId);
        System.out.println("Cohort Name: " + cohortName);
        System.out.println("\n--- Associated Course ---");
        course.displayDetails();
        System.out.println("\n--- Assigned Instructor ---");
        instructor.displayDetails();
        System.out.println("\n--- Enrolled Learners (" + learners.size() + ") ---");
        
        if (learners.isEmpty()) {
            System.out.println("No learners enrolled yet.");
        } else {
            for (Learner learner : learners) {
                System.out.println();
                learner.displayDetails();
            }
            System.out.println("\n--- Statistics ---");
            System.out.printf("Average XP: %.2f\n", calculateAverageXP());
        }
    }
}

// ============================================================================
// LMS SERVICE - Facade & Factory Pattern
// ============================================================================

/**
 * LMSService Class
 * 
 * Design Rationale:
 * - Facade Pattern: Simplifies complex subsystem interactions
 * - Factory Pattern: Centralized object creation
 * - SRP: Orchestrates operations without business logic
 * - DIP: Works with abstractions (Course, Learner)
 */
class LMSService {
    private final List<Course> courses;
    private final List<Cohort> cohorts;
    private final List<Instructor> instructors;
    private final List<Learner> learners;
    
    public LMSService() {
        this.courses = new ArrayList<>();
        this.cohorts = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.learners = new ArrayList<>();
    }
    
    // Factory method for courses - demonstrates OCP
    public Course createCourse(String id, String name, CourseSpecialization spec, 
                              CourseType type, String... additionalParams) {
        Course course;
        
        if (type == CourseType.ONLINE) {
            String platformLink = additionalParams.length > 0 ? 
                                additionalParams[0] : "https://airtribe.live";
            course = new OnlineCourse(id, name, spec, platformLink);
        } else {
            String location = additionalParams.length > 0 ? 
                            additionalParams[0] : "Bangalore";
            String schedule = additionalParams.length > 1 ? 
                            additionalParams[1] : "Weekends";
            course = new OfflineCourse(id, name, spec, location, schedule);
        }
        
        courses.add(course);
        System.out.println("✓ Created course: " + name);
        return course;
    }
    
    // Factory method for learners - demonstrates polymorphism
    public Learner createLearner(String id, String name, CourseSpecialization spec) {
        Learner learner;
        
        if (spec == CourseSpecialization.NODEJS) {
            learner = new NodeJSLearner(id, name);
        } else {
            learner = new JavaLearner(id, name);
        }
        
        learners.add(learner);
        System.out.println("✓ Created learner: " + name);
        return learner;
    }
    
    public Instructor createInstructor(String id, String name) {
        Instructor instructor = new Instructor(id, name);
        instructors.add(instructor);
        System.out.println("✓ Created instructor: " + name);
        return instructor;
    }
    
    public Cohort createCohort(String id, String name, Course course, Instructor instructor) {
        Cohort cohort = new Cohort(id, name, course, instructor);
        cohorts.add(cohort);
        System.out.println("✓ Created cohort: " + name);
        return cohort;
    }
    
    public void displayAllDetails() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     AIRTRIBE LMS - COMPLETE SYSTEM REPORT     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        System.out.println("\n📚 Total Courses: " + courses.size());
        System.out.println("👥 Total Learners: " + learners.size());
        System.out.println("👨‍🏫 Total Instructors: " + instructors.size());
        System.out.println("🎓 Total Cohorts: " + cohorts.size());
        
        for (Cohort cohort : cohorts) {
            cohort.displayDetails();
        }
    }
}

// ============================================================================
// MAIN CLASS - Demonstration
// ============================================================================

import java.util.ArrayList;
import java.util.List;

public class AirtribeLMS {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║        Welcome to Airtribe LMS v1.0            ║");
        System.out.println("║     Demonstrating OOP & SOLID Principles       ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        LMSService lms = new LMSService();
        
        // 1. Create Courses
        System.out.println("📚 STEP 1: Creating Courses\n");
        Course nodeOnline = lms.createCourse(
            "C001", "Node.js Mastery Online", 
            CourseSpecialization.NODEJS, CourseType.ONLINE, 
            "https://airtribe.live/nodejs"
        );
        
        Course nodeOffline = lms.createCourse(
            "C002", "Node.js Bootcamp Offline", 
            CourseSpecialization.NODEJS, CourseType.OFFLINE,
            "Bangalore Hub", "Mon-Fri 6PM-9PM"
        );
        
        Course javaOnline = lms.createCourse(
            "C003", "Java Full Stack Online", 
            CourseSpecialization.JAVA, CourseType.ONLINE,
            "https://airtribe.live/java"
        );
        
        Course javaOffline = lms.createCourse(
            "C004", "Java Enterprise Offline", 
            CourseSpecialization.JAVA, CourseType.OFFLINE,
            "Delhi Center", "Weekends 10AM-5PM"
        );
        
        // 2. Create Instructors
        System.out.println("\n👨‍🏫 STEP 2: Creating Instructors\n");
        Instructor instructor1 = lms.createInstructor("I001", "Priya Sharma");
        Instructor instructor2 = lms.createInstructor("I002", "Rahul Verma");
        Instructor instructor3 = lms.createInstructor("I003", "Ankit Singh");
        
        // 3. Create Cohorts
        System.out.println("\n🎓 STEP 3: Creating Cohorts\n");
        Cohort cohort1 = lms.createCohort("COH001", "Node.js Batch Jan 2025", 
                                          nodeOnline, instructor1);
        Cohort cohort2 = lms.createCohort("COH002", "Java Batch Feb 2025", 
                                          javaOnline, instructor2);
        Cohort cohort3 = lms.createCohort("COH003", "Node.js Offline Intensive", 
                                          nodeOffline, instructor3);
        
        // 4. Create and Enroll Learners
        System.out.println("\n👥 STEP 4: Creating and Enrolling Learners\n");
        
        // Node.js Learners
        Learner learner1 = lms.createLearner("L001", "Amit Kumar", 
                                             CourseSpecialization.NODEJS);
        learner1.setXP(850);
        cohort1.enrollLearner(learner1);
        
        Learner learner2 = lms.createLearner("L002", "Sneha Patel", 
                                             CourseSpecialization.NODEJS);
        learner2.setXP(920);
        cohort1.enrollLearner(learner2);
        
        Learner learner3 = lms.createLearner("L003", "Vikram Reddy", 
                                             CourseSpecialization.NODEJS);
        learner3.setXP(780);
        cohort3.enrollLearner(learner3);
        
        // Java Learners
        Learner learner4 = lms.createLearner("L004", "Priyanka Das", 
                                             CourseSpecialization.JAVA);
        learner4.setXP(1100);
        cohort2.enrollLearner(learner4);
        
        Learner learner5 = lms.createLearner("L005", "Rohan Mehta", 
                                             CourseSpecialization.JAVA);
        learner5.setXP(950);
        cohort2.enrollLearner(learner5);
        
        Learner learner6 = lms.createLearner("L006", "Ananya Iyer", 
                                             CourseSpecialization.JAVA);
        learner6.setXP(1050);
        cohort2.enrollLearner(learner6);
        
        // 5. Display All Details
        System.out.println("\n" + "=".repeat(60));
        lms.displayAllDetails();
        
        // 6. Demonstrate Polymorphism
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║       DEMONSTRATING POLYMORPHISM               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        System.out.println("\nTreating all learners uniformly through Learner abstraction:");
        List<Learner> allLearners = new ArrayList<>();
        allLearners.add(learner1);
        allLearners.add(learner4);
        
        for (Learner l : allLearners) {
            System.out.println("\n---");
            l.displayDetails(); // Polymorphic call
        }
        
        System.out.println("\n\n✅ Airtribe LMS Demo Complete!");
        System.out.println("All SOLID principles and OOP pillars demonstrated successfully.");
    }
}