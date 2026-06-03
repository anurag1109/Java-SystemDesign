package lld2.designPattern.creationalDP.builder.BuilderDesignPattern;

/**
 * BuilderPatternDocumentation - Complete Guide to Builder Pattern
 * 
 * ============================================================================
 * PROBLEM:
 * ============================================================================
 * When a class has many optional parameters, creating objects becomes complex:
 * 
 * WITHOUT BUILDER:
 * ❌ Student(name, rollNumber, email, phone, address, branch, gpa, hostel)
 * ❌ Need multiple overloaded constructors for different combinations
 * ❌ Hard to remember parameter order
 * ❌ Code becomes unreadable with many parameters
 * 
 * Example:
 * Student s1 = new Student("Amit", 101, "amit@email.com", "", "", "CSE", 8.5,
 * true);
 * Student s2 = new Student("Priya", 102, "", "9876543210", "Delhi", "ECE", 9.0,
 * false);
 * What does empty string mean? Confusing!
 * 
 * ============================================================================
 * SOLUTION: Builder Pattern
 * ============================================================================
 * The Builder Pattern provides a flexible way to construct objects by:
 * 1. Separating construction logic from the product class
 * 2. Allowing step-by-step object construction
 * 3. Using fluent API for readable code
 * 
 * WITH BUILDER:
 * ✓ Student student = new Student.StudentBuilder("Amit", 101)
 * ✓ .setEmail("amit@email.com")
 * ✓ .setBranch("CSE")
 * ✓ .setGpa(8.5)
 * ✓ .setHostelStudent(true)
 * ✓ .build();
 * 
 * ============================================================================
 * KEY COMPONENTS:
 * ============================================================================
 * 
 * 1. Product (Student)
 * - The final object to be constructed
 * - Should be immutable (all fields final)
 * - Has a private constructor
 * - Only accessible via builder.build()
 * 
 * 2. Builder (Student.StudentBuilder)
 * - Inner static class or separate class
 * - Has same fields as Student but mutable
 * - Provides setter methods that return 'this' (fluent API)
 * - Has build() method that creates the final product
 * 
 * 3. Client Code
 * - Uses the builder to construct objects
 * - Can use director for common patterns
 * 
 * 4. Director (Optional)
 * - Encapsulates common construction patterns
 * - Provides convenient methods for typical scenarios
 * - Makes client code cleaner
 * 
 * ============================================================================
 * STEP-BY-STEP PROCESS:
 * ============================================================================
 * 
 * Step 1: Create Builder with required parameters
 * StudentBuilder builder = new Student.StudentBuilder("Amit", 101);
 * 
 * Step 2: Set optional parameters (fluent API)
 * builder.setEmail("amit@email.com")
 * .setPhone("9876543210")
 * .setGpa(8.5)
 * .setHostelStudent(true);
 * 
 * Step 3: Build the final object
 * Student student = builder.build();
 * 
 * Step 4: Object is immutable - can't be changed
 * student.setEmail("new@email.com"); // ❌ ERROR - no setter available
 * 
 * ============================================================================
 * FLUENT API (Method Chaining):
 * ============================================================================
 * 
 * Traditional approach:
 * builder.setEmail("amit@email.com");
 * builder.setPhone("9876543210");
 * builder.setBranch("CSE");
 * 
 * Fluent API approach:
 * builder.setEmail("amit@email.com")
 * .setPhone("9876543210")
 * .setBranch("CSE");
 * 
 * How it works:
 * public StudentBuilder setEmail(String email) {
 * this.email = email;
 * return this; // Returns the builder itself
 * }
 * 
 * ============================================================================
 * BENEFITS:
 * ============================================================================
 * ✓ Readable Code - Easy to understand what parameters are being set
 * ✓ Flexibility - Can set any combination of optional parameters
 * ✓ Immutability - Objects can't be modified after creation
 * ✓ Default Values - Optional parameters have sensible defaults
 * ✓ No Multiple Constructors - Avoids constructor explosion
 * ✓ Encapsulation - Construction logic is hidden
 * ✓ Extensibility - Easy to add new optional parameters
 * 
 * ============================================================================
 * WHEN TO USE BUILDER PATTERN:
 * ============================================================================
 * ✓ Class has many optional parameters
 * ✓ Want to create immutable objects
 * ✓ Need different variations of the same object
 * ✓ Complex object construction process
 * ✓ Want to enforce parameter validation
 * 
 * ============================================================================
 * REAL-WORLD EXAMPLES:
 * ============================================================================
 * - StringBuilder in Java
 * - SqlSession, Configuration in MyBatis
 * - Request/Response builders in HTTP libraries
 * - UI component builders in frameworks
 * - Database query builders
 * - Lombok @Builder annotation
 * 
 * ============================================================================
 * CLASS DIAGRAM:
 * ============================================================================
 * 
 * Client
 * |
 * | creates
 * v
 * Student.StudentBuilder (Inner Static Class)
 * |
 * | builds
 * v
 * Student (Product)
 * 
 * Optional:
 * Director
 * |
 * | uses
 * v
 * Student.StudentBuilder
 * 
 * ============================================================================
 * COMPARISON WITH OTHER PATTERNS:
 * ============================================================================
 * 
 * Builder vs Factory Pattern:
 * - Builder: For complex object construction with many parameters
 * - Factory: For simple object creation without parameters
 * 
 * Builder vs Telescoping Constructor:
 * - Builder: Clean, readable, flexible
 * - Telescoping: Messy, hard to maintain, confusing parameter order
 * 
 * ============================================================================
 * COMMON MISTAKES TO AVOID:
 * ============================================================================
 * ❌ Making the builder mutable after build() is called
 * ❌ Not making the product immutable
 * ❌ Using public constructor instead of private
 * ❌ Forgetting to return 'this' in setter methods
 * ❌ Not validating parameters in build() method
 * 
 * ============================================================================
 * BEST PRACTICES:
 * ============================================================================
 * ✓ Make product immutable (all fields final)
 * ✓ Use private constructor in product class
 * ✓ Use fluent API (method chaining)
 * ✓ Set default values for optional parameters
 * ✓ Validate parameters in build() method
 * ✓ Consider using Director for common patterns
 * ✓ Use inner static class for Builder if tightly coupled
 * ✓ Add JavaDoc comments explaining each builder method
 * 
 * ============================================================================
 */
public class BuilderPatternDocumentation {
    // This is a documentation class
}
