package lld2.designPattern.creationalDP.objectPoolNoDirectObjectCreationV3;


/**
 * Client demonstrating Singleton + Object Pool Pattern
 * 
 * Key Points:
 * 1. Cannot create Connection directly (it's a private inner class)
 * 2. Cannot create multiple pools (singleton pattern)
 * 3. All connections must be obtained through singleton pool
 * 4. Enforced at compile-time!
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Singleton + Object Pool Pattern Demo");
        System.out.println("========================================\n");

        // Get singleton pool instance (first call initializes)
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(3);

        // ❌ CANNOT DO THIS (compile error - Connection is private inner class):
        // DatabaseConnectionPool.Connection conn = new DatabaseConnectionPool.Connection("id");

        // ❌ CANNOT DO THIS (private constructor):
        // DatabaseConnectionPool pool2 = new DatabaseConnectionPool(5);

        // ❌ CANNOT DO THIS (returns same instance - singleton):
        // DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance(5);

        System.out.println("--- Borrowing Connections ---");
        DatabaseConnectionPool.Connection conn1 = pool.borrowConnection();
        DatabaseConnectionPool.Connection conn2 = pool.borrowConnection();
        DatabaseConnectionPool.Connection conn3 = pool.borrowConnection();

        System.out.println("--- Using Connections ---");
        conn1.executeQuery("SELECT * FROM users WHERE id = 1");
        conn2.executeQuery("INSERT INTO products VALUES (100, 'Laptop')");
        conn3.executeQuery("UPDATE orders SET status = 'shipped'");

        System.out.println("\n--- Pool is Empty - Try to Borrow ---");
        DatabaseConnectionPool.Connection conn4 = pool.borrowConnection();

        System.out.println("\n--- Returning Connections to Pool ---");
        pool.returnConnection(conn1);
        pool.returnConnection(conn2);
        pool.returnConnection(conn3);

        System.out.println("\n--- Reusing Connections ---");
        DatabaseConnectionPool.Connection reuseConn = pool.borrowConnection();
        System.out.println("Reused: " + reuseConn.getId());
        reuseConn.executeQuery("SELECT * FROM logs");
        pool.returnConnection(reuseConn);

        System.out.println("\n========================================");
        System.out.println("Demo Complete - Enforcement at compile-time!");
        System.out.println("========================================");
    }
}