package lld2.designPattern.creationalDP.builder.BuilderDesignPattern;

/**
 * Student - Product Class (Immutable Object)
 * 
 * This class represents a student with multiple optional attributes.
 * It's immutable - once created, it cannot be changed.
 * 
 * Instead of creating multiple constructors with different parameter
 * combinations,
 * we use the Builder pattern to construct complex objects step by step.
 */
public class Student {
    // Required fields
    private final String name;
    private final int rollNumber;

    // Optional fields
    private final String email;
    private final String phone;
    private final String address;
    private final String branch;
    private final double gpa;
    private final boolean isHostelStudent;

    /**
     * Private constructor - can only be called from StudentBuilder
     * This prevents direct instantiation and enforces the builder pattern
     */
    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.rollNumber = builder.rollNumber;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.branch = builder.branch;
        this.gpa = builder.gpa;
        this.isHostelStudent = builder.isHostelStudent;
    }

    // Getters (no setters - immutable)
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getBranch() {
        return branch;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean isHostelStudent() {
        return isHostelStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", branch='" + branch + '\'' +
                ", gpa=" + gpa +
                ", isHostelStudent=" + isHostelStudent +
                '}';
    }

    /**
     * ============================================================================
     * StudentBuilder - Inner Static Class (Builder)
     * ============================================================================
     * 
     * The builder class constructs the Student object step by step.
     * It has the same fields as Student but they are mutable (not final).
     * 
     * Benefits of using inner static builder:
     * - Access to Student's private constructor
     * - Logical grouping (Builder is related to Student)
     * - Can be extended without affecting Student class
     */
    public static class StudentBuilder {
        // Required fields
        private final String name;
        private final int rollNumber;

        // Optional fields - initialized with default values
        private String email = "";
        private String phone = "";
        private String address = "";
        private String branch = "CSE";
        private double gpa = 0.0;
        private boolean isHostelStudent = false;

        /**
         * Constructor - requires only mandatory fields
         * 
         * @param name       Student name (required)
         * @param rollNumber Roll number (required)
         */
        public StudentBuilder(String name, int rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
        }

        /**
         * Set email - fluent API (returns 'this' for chaining)
         */
        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * Set phone - fluent API
         */
        public StudentBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Set address - fluent API
         */
        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Set branch - fluent API
         */
        public StudentBuilder setBranch(String branch) {
            this.branch = branch;
            return this;
        }

        /**
         * Set GPA - fluent API
         */
        public StudentBuilder setGpa(double gpa) {
            this.gpa = gpa;
            return this;
        }

        /**
         * Set hostel student flag - fluent API
         */
        public StudentBuilder setHostelStudent(boolean hostelStudent) {
            this.isHostelStudent = hostelStudent;
            return this;
        }

        /**
         * Build - creates the final Student object
         * This is the only way to create a Student instance
         * 
         * @return A new immutable Student object
         */
        public Student build() {
            return new Student(this);
        }
    }
}
