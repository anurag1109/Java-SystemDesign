package lld1.SOLID;

import java.util.ArrayList;
import java.util.List;

/**
 * DEPENDENCY INVERSION PRINCIPLE (DIP)
 * 
 * Definition: High-level modules should not depend on low-level modules.
 * Both should depend on abstractions. Abstractions should not depend on details,
 * details should depend on abstractions.
 * 
 * Key Points:
 * 1. Depend on abstractions (interfaces/abstract classes), not concrete implementations
 * 2. Use dependency injection to provide implementations
 * 3. High-level modules should define the interface
 * 4. Low-level modules should implement the interface
 * 5. Invert the dependency flow - from concrete to abstract
 * 
 * Benefits:
 * - Loose coupling between modules
 * - Easier to test (can inject mock objects)
 * - Easier to swap implementations
 * - More flexible and maintainable code
 * - Better separation of concerns
 */

// ============================================================================
// BAD EXAMPLE: Violating Dependency Inversion Principle
// ============================================================================

/**
 * Low-level module: Directly accesses database
 * This is tightly coupled and hard to test
 */
class MySQLDatabaseBad {
    public void save(String data) {
        System.out.println("Saving data to MySQL: " + data);
        // MySQL specific implementation
    }

    public String retrieve(int id) {
        System.out.println("Retrieving data from MySQL with ID: " + id);
        return "MySQL Data";
    }

    public void update(int id, String data) {
        System.out.println("Updating MySQL data with ID: " + id + " to: " + data);
    }

    public void delete(int id) {
        System.out.println("Deleting MySQL data with ID: " + id);
    }
}

/**
 * Another low-level module: Directly accesses file system
 */
class FileSystemBad {
    public void save(String data) {
        System.out.println("Saving data to File System: " + data);
        // File specific implementation
    }

    public String retrieve(int id) {
        System.out.println("Retrieving data from File System with ID: " + id);
        return "File System Data";
    }
}

/**
 * High-level module: Directly depends on low-level modules
 * This violates DIP!
 * Problems:
 * 1. UserService depends directly on MySQLDatabaseBad - tight coupling
 * 2. If we want to switch to FileSystemBad or another database, we must modify
 * UserService
 * 3. Hard to test - can't inject mock database
 * 4. Changes in MySQLDatabaseBad affect UserService
 */
class UserServiceBad {
    // Direct dependency on concrete class - TIGHT COUPLING
    private MySQLDatabaseBad database = new MySQLDatabaseBad();

    public void registerUser(String username, String email) {
        System.out.println("Registering user: " + username);
        String userData = username + ":" + email;
        database.save(userData); // Tightly coupled to MySQL
    }

    public String getUserData(int userId) {
        return database.retrieve(userId); // Tightly coupled to MySQL
    }

    public void updateUserData(int userId, String newEmail) {
        String userData = "updatedUser:" + newEmail;
        database.update(userId, userData); // Tightly coupled to MySQL
    }

    public void deleteUser(int userId) {
        database.delete(userId); // Tightly coupled to MySQL
    }
}

/**
 * If we want to use FileSystemBad instead of MySQLDatabaseBad,
 * we would need to:
 * 1. Create a new UserServiceForFile class
 * 2. Or modify the existing UserServiceBad
 * This is not scalable and violates DIP
 */

// ============================================================================
// GOOD EXAMPLE: Following Dependency Inversion Principle
// ============================================================================

/**
 * Abstraction: Database interface
 * High-level modules depend on this, not concrete implementations
 */
interface Database {
    /**
     * Save data to the database
     */
    void save(String data);

    /**
     * Retrieve data from the database
     */
    String retrieve(int id);

    /**
     * Update data in the database
     */
    void update(int id, String data);

    /**
     * Delete data from the database
     */
    void delete(int id);
}

/**
 * Low-level module: MySQL implementation
 * Depends on the Database abstraction
 */
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MySQL: " + data);
        // MySQL specific implementation
    }

    @Override
    public String retrieve(int id) {
        System.out.println("Retrieving data from MySQL with ID: " + id);
        return "MySQL Data";
    }

    @Override
    public void update(int id, String data) {
        System.out.println("Updating MySQL data with ID: " + id + " to: " + data);
    }

    @Override
    public void delete(int id) {
        System.out.println("Deleting MySQL data with ID: " + id);
    }
}

/**
 * Low-level module: MongoDB implementation
 * Also implements the Database abstraction
 * Can be swapped in without changing UserService
 */
class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MongoDB: " + data);
        // MongoDB specific implementation
    }

    @Override
    public String retrieve(int id) {
        System.out.println("Retrieving data from MongoDB with ID: " + id);
        return "MongoDB Data";
    }

    @Override
    public void update(int id, String data) {
        System.out.println("Updating MongoDB data with ID: " + id + " to: " + data);
    }

    @Override
    public void delete(int id) {
        System.out.println("Deleting MongoDB data with ID: " + id);
    }
}

/**
 * Low-level module: PostgreSQL implementation
 * Also implements the Database abstraction
 */
class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to PostgreSQL: " + data);
        // PostgreSQL specific implementation
    }

    @Override
    public String retrieve(int id) {
        System.out.println("Retrieving data from PostgreSQL with ID: " + id);
        return "PostgreSQL Data";
    }

    @Override
    public void update(int id, String data) {
        System.out.println("Updating PostgreSQL data with ID: " + id + " to: " + data);
    }

    @Override
    public void delete(int id) {
        System.out.println("Deleting PostgreSQL data with ID: " + id);
    }
}

/**
 * Low-level module: File System implementation
 * Can also be used interchangeably with other databases
 */
class FileSystemDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to File System: " + data);
        // File specific implementation
    }

    @Override
    public String retrieve(int id) {
        System.out.println("Retrieving data from File System with ID: " + id);
        return "File System Data";
    }

    @Override
    public void update(int id, String data) {
        System.out.println("Updating File System data with ID: " + id + " to: " + data);
    }

    @Override
    public void delete(int id) {
        System.out.println("Deleting File System data with ID: " + id);
    }
}

/**
 * High-level module: UserService
 * Depends on Database abstraction, NOT concrete implementations
 * This follows DIP!
 * 
 * Advantages:
 * 1. UserService can work with ANY Database implementation
 * 2. Easy to switch databases without modifying UserService
 * 3. Easy to test with mock databases
 * 4. Loose coupling between UserService and specific database
 * 5. Dependencies are injected, not created internally
 */
class UserService {
    // Depends on abstraction, not concrete class
    private Database database;

    // Constructor injection: Client provides the implementation
    public UserService(Database database) {
        this.database = database;
    }

    // Method injection: Allows changing database at runtime if needed
    public void setDatabase(Database database) {
        this.database = database;
    }

    public void registerUser(String username, String email) {
        System.out.println("Registering user: " + username);
        String userData = username + ":" + email;
        database.save(userData); // Works with ANY Database implementation
    }

    public String getUserData(int userId) {
        return database.retrieve(userId); // Works with ANY Database implementation
    }

    public void updateUserData(int userId, String newEmail) {
        String userData = "updatedUser:" + newEmail;
        database.update(userId, userData); // Works with ANY Database implementation
    }

    public void deleteUser(int userId) {
        database.delete(userId); // Works with ANY Database implementation
    }
}

/**
 * Another high-level module: UserRepository
 * Also follows DIP
 */
class UserRepository {
    private Database database;

    public UserRepository(Database database) {
        this.database = database;
    }

    public void saveUserProfile(String name, String profile) {
        String userData = name + "|" + profile;
        database.save(userData);
    }

    public String loadUserProfile(int userId) {
        return database.retrieve(userId);
    }

    public void updateUserProfile(int userId, String newProfile) {
        database.update(userId, newProfile);
    }

    public void removeUserProfile(int userId) {
        database.delete(userId);
    }
}

/**
 * Notification service: Another high-level module
 * Also depends on abstraction
 */
interface NotificationService {
    void send(String message);
}

/**
 * Email notification: Low-level module
 */
class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

/**
 * SMS notification: Low-level module
 */
class SMSNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

/**
 * Alert system: High-level module
 * Depends on NotificationService abstraction
 */
class AlertSystem {
    private List<NotificationService> notifications = new ArrayList<>();

    public void addNotification(NotificationService notification) {
        notifications.add(notification);
    }

    public void sendAlert(String message) {
        System.out.println("Alert: " + message);
        for (NotificationService notification : notifications) {
            notification.send(message); // Works with ANY NotificationService
        }
    }
}

/**
 * ApplicationFactory: Creates and wires dependencies
 * This is where we control which implementations to use
 */
class ApplicationFactory {
    /**
     * Create user service with MySQL database
     */
    public static UserService createUserServiceWithMySQL() {
        Database database = new MySQLDatabase();
        return new UserService(database);
    }

    /**
     * Create user service with MongoDB
     */
    public static UserService createUserServiceWithMongoDB() {
        Database database = new MongoDBDatabase();
        return new UserService(database);
    }

    /**
     * Create user service with PostgreSQL
     */
    public static UserService createUserServiceWithPostgreSQL() {
        Database database = new PostgreSQLDatabase();
        return new UserService(database);
    }

    /**
     * Create user service with File System
     */
    public static UserService createUserServiceWithFileSystem() {
        Database database = new FileSystemDatabase();
        return new UserService(database);
    }

    /**
     * Create alert system with multiple notifications
     */
    public static AlertSystem createAlertSystem() {
        AlertSystem alertSystem = new AlertSystem();
        alertSystem.addNotification(new EmailNotification());
        alertSystem.addNotification(new SMSNotification());
        return alertSystem;
    }
}

/**
 * Mock database for testing
 * This is where DIP really shines - we can inject mocks for testing
 */
class MockDatabase implements Database {
    private List<String> storage = new ArrayList<>();

    @Override
    public void save(String data) {
        storage.add(data);
        System.out.println("[MOCK] Saved: " + data);
    }

    @Override
    public String retrieve(int id) {
        System.out.println("[MOCK] Retrieved data from index: " + id);
        return storage.size() > id ? storage.get(id) : "No data";
    }

    @Override
    public void update(int id, String data) {
        if (storage.size() > id) {
            storage.set(id, data);
            System.out.println("[MOCK] Updated: " + data);
        }
    }

    @Override
    public void delete(int id) {
        if (storage.size() > id) {
            storage.remove(id);
            System.out.println("[MOCK] Deleted data at index: " + id);
        }
    }
}

// ============================================================================
// CLIENT: Demonstrating Dependency Inversion Principle
// ============================================================================

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Dependency Inversion Principle (DIP) ===\n");

        // Demonstrate dependency injection with different databases
        System.out.println("--- Using UserService with Different Database Implementations ---\n");

        System.out.println("1. UserService with MySQL:");
        UserService mysqlService = ApplicationFactory.createUserServiceWithMySQL();
        mysqlService.registerUser("john_mysql", "john@mysql.com");
        System.out.println(mysqlService.getUserData(1));

        System.out.println("\n2. UserService with MongoDB:");
        UserService mongoService = ApplicationFactory.createUserServiceWithMongoDB();
        mongoService.registerUser("john_mongo", "john@mongo.com");
        System.out.println(mongoService.getUserData(1));

        System.out.println("\n3. UserService with PostgreSQL:");
        UserService postgresService = ApplicationFactory.createUserServiceWithPostgreSQL();
        postgresService.registerUser("john_postgres", "john@postgres.com");
        System.out.println(postgresService.getUserData(1));

        System.out.println("\n4. UserService with File System:");
        UserService fileService = ApplicationFactory.createUserServiceWithFileSystem();
        fileService.registerUser("john_file", "john@file.com");
        System.out.println(fileService.getUserData(1));

        // Demonstrate testing with mock database
        System.out.println("\n--- Testing with Mock Database ---");
        System.out.println("(Demonstrates the power of DIP for testing)");
        Database mockDatabase = new MockDatabase();
        UserService testService = new UserService(mockDatabase);

        testService.registerUser("test_user", "test@example.com");
        testService.updateUserData(0, "updated_email@example.com");
        System.out.println("Retrieved: " + testService.getUserData(0));
        testService.deleteUser(0);

        // Demonstrate UserRepository with different databases
        System.out.println("\n--- UserRepository with Different Implementations ---\n");

        UserRepository mysqlRepo = new UserRepository(new MySQLDatabase());
        System.out.println("MySQL Repository:");
        mysqlRepo.saveUserProfile("Alice", "Senior Developer");
        System.out.println(mysqlRepo.loadUserProfile(1));

        UserRepository mongoRepo = new UserRepository(new MongoDBDatabase());
        System.out.println("\nMongoDB Repository:");
        mongoRepo.saveUserProfile("Bob", "Product Manager");
        System.out.println(mongoRepo.loadUserProfile(1));

        // Demonstrate alert system with dependency injection
        System.out.println("\n--- Alert System with Multiple Notifications ---");
        AlertSystem alertSystem = ApplicationFactory.createAlertSystem();
        alertSystem.sendAlert("System maintenance in 10 minutes!");

        // Demonstrate switching implementations at runtime
        System.out.println("\n--- Switching Database Implementation at Runtime ---");
        UserService runtimeService = new UserService(new MySQLDatabase());
        runtimeService.registerUser("runtime_user", "runtime@example.com");

        System.out.println("\nSwitching to MongoDB...");
        runtimeService.setDatabase(new MongoDBDatabase());
        runtimeService.updateUserData(1, "switched@example.com");

        System.out.println("\n=== Conclusion ===");
        System.out.println("By following DIP:");
        System.out.println("1. High-level modules depend on abstractions, not concrete implementations");
        System.out.println("2. Easy to swap implementations without modifying high-level code");
        System.out.println("3. Easy to test using mock implementations");
        System.out.println("4. Loose coupling between modules");
        System.out.println("5. More flexible and maintainable architecture");
        System.out.println("6. Dependencies are injected, not hardcoded");
    }
}
