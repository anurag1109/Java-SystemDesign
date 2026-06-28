package lld2.designPattern.creationalDP.objectPoolWithSingletonV2;

import java.util.ArrayList;
import java.util.List;

/**
 * SINGLETON Object Pool
 * Only ONE instance of this pool exists in entire application
 * All database connections must be obtained through this singleton
 */
public class DatabaseConnectionPool {
    // SINGLETON INSTANCE
    private static DatabaseConnectionPool instance;

    // Pool data
    private final List<SingletonDatabaseConnection> availableConnections = new ArrayList<>();
    private final List<SingletonDatabaseConnection> usedConnections = new ArrayList<>();
    private final int poolSize;

    // PRIVATE constructor - cannot instantiate directly!
    private DatabaseConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        initializePool();
    }

    /**
     * Get the SINGLETON instance of the pool
     * Thread-safe lazy initialization
     */
    public static synchronized DatabaseConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            instance = new DatabaseConnectionPool(poolSize);
        }
        return instance;
    }

    /**
     * Get the singleton instance (if already initialized)
     */
    public static synchronized DatabaseConnectionPool getInstance() {
        if (instance == null) {
            throw new RuntimeException("Pool not initialized! Call getInstance(poolSize) first");
        }
        return instance;
    }

    /**
     * Initialize pool with connections
     */
    private void initializePool() {
        System.out.println("🔄 Initializing Database Connection Pool with " + poolSize + " connections...");
        for (int i = 1; i <= poolSize; i++) {
            SingletonDatabaseConnection conn = SingletonDatabaseConnection.create("DB-Conn-" + i);
            availableConnections.add(conn);
        }
        System.out.println("✅ Pool initialized successfully\n");
    }

    /**
     * Borrow a connection from the pool
     */
    public synchronized SingletonDatabaseConnection borrowConnection() {
        if (availableConnections.isEmpty()) {
            System.out.println("❌ No available connections! Please wait or increase pool size.");
            return null;
        }

        SingletonDatabaseConnection conn = availableConnections.remove(0);
        usedConnections.add(conn);
        System.out.println("📤 Borrowed: " + conn.getId());
        printStats();
        return conn;
    }

    /**
     * Return a connection to the pool
     */
    public synchronized void returnConnection(SingletonDatabaseConnection conn) {
        if (conn == null) return;

        if (usedConnections.remove(conn)) {
            conn.reset();
            availableConnections.add(conn);
            System.out.println("📥 Returned: " + conn.getId());
        } else {
            System.out.println("⚠️  Connection not found in used list!");
        }
        printStats();
    }

    /**
     * Print pool statistics
     */
    public void printStats() {
        System.out.println("   [Pool Stats] Available: " + availableConnections.size() + 
                         " | In Use: " + usedConnections.size() + "\n");
    }

    public int getAvailableCount() {
        return availableConnections.size();
    }

    public int getUsedCount() {
        return usedConnections.size();
    }
}