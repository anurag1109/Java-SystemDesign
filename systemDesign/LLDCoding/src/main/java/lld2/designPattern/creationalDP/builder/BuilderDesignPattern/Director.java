package lld2.designPattern.creationalDP.builder.BuilderDesignPattern;

/**
 * Director - Encapsulates Complex Construction Logic
 * 
 * The Director class knows how to construct complex objects.
 * It provides methods to build students with pre-defined configurations.
 * 
 * Benefits:
 * - Separates construction logic from the builder
 * - Provides convenient methods for common scenarios
 * - Makes client code simpler and more readable
 */
public class Director {

    /**
     * Build an Engineering Student with common attributes
     * This is a common construction pattern we can reuse
     */
    public Student buildEngineeringStudent(String name, int rollNumber, String branch) {
        return new Student.StudentBuilder(name, rollNumber)
                .setBranch(branch)
                .setGpa(7.5) // Default GPA for engineering students
                .setHostelStudent(true) // Most engineering students live in hostels
                .build();
    }

    /**
     * Build a Day Scholar (Non-hostel) Student
     */
    public Student buildDayScholarStudent(String name, int rollNumber, String email, String phone) {
        return new Student.StudentBuilder(name, rollNumber)
                .setEmail(email)
                .setPhone(phone)
                .setHostelStudent(false) // Day scholar - doesn't stay in hostel
                .setGpa(8.0) // Typically better GPA
                .build();
    }

    /**
     * Build a Hostel Student with complete details
     */
    public Student buildHostelStudent(String name, int rollNumber, String branch,
            String address, String phone, double gpa) {
        return new Student.StudentBuilder(name, rollNumber)
                .setBranch(branch)
                .setAddress(address)
                .setPhone(phone)
                .setGpa(gpa)
                .setHostelStudent(true)
                .build();
    }

    /**
     * Build a Minimal Student (only required fields)
     */
    public Student buildMinimalStudent(String name, int rollNumber) {
        return new Student.StudentBuilder(name, rollNumber)
                .build();
    }
}
