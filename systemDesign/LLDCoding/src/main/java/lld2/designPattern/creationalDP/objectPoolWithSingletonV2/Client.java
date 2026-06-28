package lld2.designPattern.creationalDP.objectPoolWithSingletonV2;

/**
 * Client demonstrating Singleton + Object Pool Pattern
 * 
 * Key Points:
 * 1. Cannot create DatabaseConnection directly (private constructor)
 * 2. Cannot create multiple pools (singleton)
 * 3. All connections must be obtained through singleton pool
 * 4. Enforces pool pattern usage
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Singleton + Object Pool Pattern Demo");
        System.out.println("========================================\n");

        // Get singleton pool instance (first call initializes)
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(3);

        // ❌ This would NOT compile (private constructor):
        // SingletonDatabaseConnection conn = new SingletonDatabaseConnection("id");

        // ❌ This would return same instance (singleton):
        // DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance(5);

        System.out.println("--- Borrowing Connections ---");
        SingletonDatabaseConnection conn1 = pool.borrowConnection();
        SingletonDatabaseConnection conn2 = pool.borrowConnection();
        SingletonDatabaseConnection conn3 = pool.borrowConnection();

        System.out.println("--- Using Connections ---");
        conn1.executeQuery("SELECT * FROM users WHERE id = 1");
        conn2.executeQuery("INSERT INTO products VALUES (100, 'Laptop')");
        conn3.executeQuery("UPDATE orders SET status = 'shipped'");

        System.out.println("\n--- Pool is Empty - Try to Borrow ---");
        SingletonDatabaseConnection conn4 = pool.borrowConnection();

        System.out.println("\n--- Returning Connections to Pool ---");
        pool.returnConnection(conn1);
        pool.returnConnection(conn2);
        pool.returnConnection(conn3);

        System.out.println("\n--- Reusing Connections ---");
        SingletonDatabaseConnection reuseConn = pool.borrowConnection();
        System.out.println("Reused: " + reuseConn.getId());
        reuseConn.executeQuery("SELECT * FROM logs");
        pool.returnConnection(reuseConn);

        System.out.println("\n========================================");
        System.out.println("Demo Complete - Pool enforced singleton!");
        System.out.println("========================================");

        // ❌ This is still Wrong as we can create connection directly without pool
        // (bypassing singleton enforcement)
        SingletonDatabaseConnection d1 = SingletonDatabaseConnection.create("Direct-Conn-1");
        d1.executeQuery("SELECT * FROM users");
    }
}