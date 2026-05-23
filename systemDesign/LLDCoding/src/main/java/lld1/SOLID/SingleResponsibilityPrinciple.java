package lld1.SOLID;

/**
 * SINGLE RESPONSIBILITY PRINCIPLE (SRP)
 * 
 * Definition: A class should have only one reason to change, meaning it should have only one responsibility.
 * 
 * Key Points:
 * 1. Each class should be responsible for a single piece of functionality
 * 2. The responsibility should be entirely encapsulated within the class
 * 3. A class should have only one reason to change
 * 4. High cohesion and low coupling
 * 
 * Benefits:
 * - Easier to understand, maintain, and test
 * - Reduces complexity
 * - Increases reusability
 * - Makes code more flexible and robust
 */

// ============================================================================
// BAD EXAMPLE: Violating Single Responsibility Principle
// ============================================================================

/**
 * This class violates SRP because it has multiple responsibilities:
 * 1. Managing user data
 * 2. Saving to database
 * 3. Sending email notifications
 * 4. Logging activities
 * 
 * If any of these responsibilities need to change, this class needs
 * modification.
 */
class UserManagerBad {
    // User data
    private String name;
    private String email;
    private String password;

    // Database operations mixed with business logic
    public void saveUserToDatabase() {
        System.out.println("Saving user " + name + " to database");
        // Database code here
    }

    // Email operations mixed with business logic
    public void sendWelcomeEmail() {
        System.out.println("Sending welcome email to " + email);
        // Email sending logic here
    }

    // Logging operations mixed with business logic
    public void logUserCreation() {
        System.out.println("User " + name + " created at " + System.currentTimeMillis());
        // Logging logic here
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// ============================================================================
// GOOD EXAMPLE: Following Single Responsibility Principle
// ============================================================================

/**
 * User class: Responsible only for storing user data
 * Single Responsibility: Managing user information
 */
class User {
    private String name;
    private String email;
    private String password;

    // Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

/**
 * UserRepository: Responsible only for database operations
 * Single Responsibility: Handling persistence layer
 */
class UserRepository {
    // Responsibility: Save user to database
    public void saveUser(User user) {
        System.out.println("Saving user " + user.getName() + " to database...");
        // Database connection and query logic
    }

    // Responsibility: Retrieve user from database
    public User getUserById(int id) {
        System.out.println("Retrieving user with ID: " + id + " from database");
        // Database query logic
        return new User("John", "john@email.com", "password123");
    }

    // Responsibility: Update user in database
    public void updateUser(User user) {
        System.out.println("Updating user " + user.getName() + " in database");
        // Database update logic
    }

    // Responsibility: Delete user from database
    public void deleteUser(int id) {
        System.out.println("Deleting user with ID: " + id + " from database");
        // Database delete logic
    }
}

/**
 * EmailService: Responsible only for sending emails
 * Single Responsibility: Email communication
 */
class EmailService {
    // Responsibility: Send welcome email
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending welcome email to: " + user.getEmail());
        System.out.println("Dear " + user.getName() + ", Welcome to our application!");
        // SMTP configuration and email sending logic
    }

    // Responsibility: Send password reset email
    public void sendPasswordResetEmail(User user) {
        System.out.println("Sending password reset email to: " + user.getEmail());
        // Email sending logic
    }

    // Responsibility: Send notification email
    public void sendNotificationEmail(String email, String message) {
        System.out.println("Sending notification email to: " + email);
        System.out.println("Message: " + message);
        // Email sending logic
    }
}

/**
 * UserLogger: Responsible only for logging user activities
 * Single Responsibility: Logging user-related activities
 */
class UserLogger {
    // Responsibility: Log user creation
    public void logUserCreation(User user) {
        System.out.println("[LOG] User created: " + user.getName() +
                " at " + System.currentTimeMillis());
    }

    // Responsibility: Log user login
    public void logUserLogin(String username) {
        System.out.println("[LOG] User " + username + " logged in at " +
                System.currentTimeMillis());
    }

    // Responsibility: Log user deletion
    public void logUserDeletion(String username) {
        System.out.println("[LOG] User " + username + " deleted at " +
                System.currentTimeMillis());
    }
}

/**
 * UserService: Coordinates between different services
 * This follows SRP by orchestrating operations without doing them directly
 */
class UserService {
    private UserRepository userRepository;
    private EmailService emailService;
    private UserLogger userLogger;

    // Constructor with dependency injection
    public UserService(UserRepository userRepository,
            EmailService emailService,
            UserLogger userLogger) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userLogger = userLogger;
    }

    // Orchestrate the user creation process
    public void createUser(String name, String email, String password) {
        // Create user object
        User user = new User(name, email, password);

        // Use each service for its specific responsibility
        userRepository.saveUser(user);
        emailService.sendWelcomeEmail(user);
        userLogger.logUserCreation(user);

        System.out.println("User created successfully!\n");
    }

    // Orchestrate the user deletion process
    public void deleteUser(int userId, String username) {
        userRepository.deleteUser(userId);
        userLogger.logUserDeletion(username);
        System.out.println("User deleted successfully!\n");
    }
}

// ============================================================================
// CLIENT: Demonstrating Single Responsibility Principle
// ============================================================================

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Single Responsibility Principle (SRP) ===\n");

        // Initialize dependencies
        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();
        UserLogger userLogger = new UserLogger();

        // Create UserService with all dependencies
        UserService userService = new UserService(userRepository, emailService, userLogger);

        // Create a new user
        System.out.println("--- Creating New User ---");
        userService.createUser("John Doe", "john@example.com", "secure123");

        // Delete a user
        System.out.println("--- Deleting User ---");
        userService.deleteUser(1, "John Doe");

        // Directly use individual services
        System.out.println("--- Using Individual Services ---");
        User user = new User("Jane Smith", "jane@example.com", "password456");
        userRepository.saveUser(user);
        emailService.sendPasswordResetEmail(user);
        userLogger.logUserLogin("jane@example.com");

        System.out.println("\n=== Conclusion ===");
        System.out.println("By following SRP:");
        System.out.println("1. Each class has a clear, single purpose");
        System.out.println("2. Changes to database logic don't affect email logic");
        System.out.println("3. Each class is easy to test independently");
        System.out.println("4. Code is more maintainable and scalable");
    }
}
