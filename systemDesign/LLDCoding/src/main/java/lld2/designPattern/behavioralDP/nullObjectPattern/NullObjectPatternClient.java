package lld2.designPattern.behavioralDP.nullObjectPattern;

/**
 * NullObjectPatternClient - Demonstrates the Null Object Pattern
 * Shows how using Null Objects eliminates the need for null checks
 */
public class NullObjectPatternClient {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   Null Object Pattern Demonstration       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ===== Without Null Object Pattern (Bad) =====
        System.out.println("❌ WITHOUT Null Object Pattern (Old Way - With Null Checks):");
        System.out.println("────────────────────────────────────────────");
        demonstrateWithoutNullObject();

        System.out.println("\n");

        // ===== With Null Object Pattern (Good) =====
        System.out.println("✓ WITH Null Object Pattern (Better Way - No Null Checks):");
        System.out.println("────────────────────────────────────────────");
        demonstrateWithNullObject();

        System.out.println("\n");

        // ===== Logger Example =====
        System.out.println("📝 Logger Example:");
        System.out.println("────────────────────────────────────────────");
        demonstrateLoggerPattern();

        System.out.println("\n");
        System.out.println("✓ No NullPointerException errors throughout!");
    }

    // Demonstrates the BAD way - With null checks
    static void demonstrateWithoutNullObject() {
        UserService user1 = getUser("Amit"); // Returns real user
        UserService user2 = getUser("Unknown"); // Returns null

        // Need to check for null everywhere
        if (user1 != null) {
            user1.login();
            user1.sendEmail("Hello!");
        }

        // Without null check, this would throw NullPointerException
        if (user2 != null) {
            user2.login();
            user2.sendEmail("Hello!");
        } else {
            System.out.println("⚠ User not found - cannot perform operations");
        }
    }

    // Demonstrates the GOOD way - With Null Object
    static void demonstrateWithNullObject() {
        UserService user1 = getUserWithNullObject("Amit"); // Returns real user
        UserService user2 = getUserWithNullObject("Unknown"); // Returns NullUser

        // No null checks needed! Works safely with both real and null objects
        System.out.println("\nUser 1 operations:");
        user1.login();
        user1.sendEmail("Hello from User 1!");

        System.out.println("\nUser 2 operations (silently does nothing):");
        user2.login(); // Silently does nothing
        user2.sendEmail("Hello from User 2!"); // Silently does nothing
        System.out.println("↳ NullUser performed no-op operations safely");
    }

    // Demonstrates Logger pattern
    static void demonstrateLoggerPattern() {
        // Real logger - logs to console
        LoggerService logger1 = new FileLogger();
        logger1.logInfo("Application started");
        logger1.logWarning("This is a warning");

        System.out.println("\nWith NullLogger (debugging disabled):");
        // Null logger - does nothing (useful for disabling logs)
        LoggerService logger2 = new NullLogger();
        logger2.logInfo("This won't be printed"); // Does nothing
        logger2.logWarning("This won't be printed either"); // Does nothing
        System.out.println("↳ NullLogger suppressed all log messages");
    }

    // Simulates getting a user - could return null (BAD way)
    static UserService getUser(String username) {
        if (username.equals("Amit")) {
            return new RealUser("Amit");
        }
        return null; // This is problematic!
    }

    // Simulates getting a user - always returns an object (GOOD way)
    static UserService getUserWithNullObject(String username) {
        if (username.equals("Amit")) {
            return new RealUser("Amit");
        }
        return new NullUser(); // Returns NullUser instead of null
    }
}
