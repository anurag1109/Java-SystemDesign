package lld2.designPattern.creationalDP.objectPoolV1;

/**
 * Client demonstrating the Object Pool pattern
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Object Pool Design Pattern Demo ===\n");

        // Create a pool with 3 database connections
        ObjectPool pool = new ObjectPool(new DatabaseConnectionFactory(), 3);
        pool.printStats();

        // Borrow and use connections
        System.out.println("--- Borrowing Connections ---");
        DatabaseConnection conn1 = (DatabaseConnection) pool.borrowObject();
        DatabaseConnection conn2 = (DatabaseConnection) pool.borrowObject();
        DatabaseConnection conn3 = (DatabaseConnection) pool.borrowObject();
        pool.printStats();

        // Use the connections
        System.out.println("\n--- Using Connections ---");
        conn1.executeQuery("SELECT * FROM users");
        conn2.executeQuery("SELECT * FROM products");
        conn3.executeQuery("INSERT INTO logs VALUES (...)");

        // Try to borrow when pool is empty
        System.out.println("\n--- Pool is Empty ---");
        Poolable conn4 = pool.borrowObject();
        pool.printStats();

        // Return connections to pool
        System.out.println("--- Returning Connections ---");
        pool.returnObject(conn1);
        pool.returnObject(conn2);
        pool.returnObject(conn3);
        pool.printStats();

        // Reuse connections
        System.out.println("--- Reusing Connections ---");
        DatabaseConnection reuseConn1 = (DatabaseConnection) pool.borrowObject();
        System.out.println("Reused connection: " + reuseConn1.getId());
        reuseConn1.executeQuery("SELECT * FROM orders");
        pool.returnObject(reuseConn1);

        pool.printStats();
        System.out.println("\n=== Demo Complete ===");
    }
}