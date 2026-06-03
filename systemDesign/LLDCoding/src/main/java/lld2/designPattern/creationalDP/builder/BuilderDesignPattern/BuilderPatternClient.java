package lld2.designPattern.creationalDP.builder.BuilderDesignPattern;

/**
 * BuilderPatternClient - Demonstrates the Builder Pattern
 * 
 * This class shows different ways to use the Builder pattern:
 * 1. Direct builder usage - for custom configurations
 * 2. Director usage - for pre-defined configurations
 */
public class BuilderPatternClient {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Builder Design Pattern Demo");
        System.out.println("========================================\n");

        // ===== Method 1: Direct Builder Usage =====
        System.out.println("METHOD 1: Direct Builder Usage");
        System.out.println("-".repeat(50));

        // Create a student with custom configuration
        Student student1 = new Student.StudentBuilder("Amit Kumar", 101)
                .setEmail("amit@email.com")
                .setPhone("9876543210")
                .setAddress("Delhi")
                .setBranch("CSE")
                .setGpa(8.5)
                .setHostelStudent(true)
                .build();

        System.out.println("Student 1: " + student1);
        System.out.println();

        // Create another student with different configuration
        Student student2 = new Student.StudentBuilder("Priya Singh", 102)
                .setEmail("priya@email.com")
                .setPhone("9876543211")
                .setBranch("ECE")
                .setGpa(9.0)
                .build();

        System.out.println("Student 2: " + student2);
        System.out.println();

        // Create a student with minimal information
        Student student3 = new Student.StudentBuilder("Raj Patel", 103)
                .build();

        System.out.println("Student 3 (Minimal): " + student3);
        System.out.println();

        // ===== Method 2: Using Director =====
        System.out.println("\nMETHOD 2: Using Director");
        System.out.println("-".repeat(50));

        Director director = new Director();

        // Build an engineering student using director
        Student enggStudent = director.buildEngineeringStudent("Vikram Singh", 201, "Mechanical");
        System.out.println("Engineering Student: " + enggStudent);
        System.out.println();

        // Build a day scholar using director
        Student dayScholar = director.buildDayScholarStudent(
                "Neha Gupta",
                202,
                "neha@email.com",
                "9876543212");
        System.out.println("Day Scholar Student: " + dayScholar);
        System.out.println();

        // Build a hostel student with complete details using director
        Student hostelStudent = director.buildHostelStudent(
                "Arun Kumar",
                203,
                "Civil",
                "Mumbai",
                "9876543213",
                7.8);
        System.out.println("Hostel Student: " + hostelStudent);
        System.out.println();

        // ===== Benefits Demonstration =====
        System.out.println("\nKEY BENEFITS:");
        System.out.println("-".repeat(50));
        System.out.println("✓ No need for multiple constructors");
        System.out.println("✓ Clear and readable construction process");
        System.out.println("✓ Optional parameters handled elegantly");
        System.out.println("✓ Fluent API for chaining method calls");
        System.out.println("✓ Immutable objects - can't be modified after creation");
        System.out.println("✓ Director encapsulates common construction patterns");
        System.out.println("✓ Easy to add new optional fields");
    }
}
