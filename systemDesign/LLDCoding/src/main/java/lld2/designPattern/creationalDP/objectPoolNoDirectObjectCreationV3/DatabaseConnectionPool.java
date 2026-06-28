package lld2.designPattern.creationalDP.objectPoolNoDirectObjectCreationV3;

import java.util.ArrayList;
import java.util.List;

/**
 * SINGLETON Object Pool with inner Connection class
 * Only the pool can create connections - completely enforced!
 */
public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();
    private final int poolSize;

    /**
     * INNER CLASS - PRIVATE!
     * Can ONLY be instantiated by the pool
     */
    public class Connection {
        private final String id;
        private String query;
        private boolean isActive;

        // PRIVATE constructor - only pool can create via inner class
        private Connection(String id) {
            this.id = id;
            this.query = "";
            this.isActive = false;
        }

        public void executeQuery(String sql) {
            this.isActive = true;
            this.query = sql;
            System.out.println("[" + id + "] Executing: " + sql);
        }

        public void reset() {
            this.query = "";
            this.isActive = false;
            System.out.println("[" + id + "] Connection reset and returned to pool");
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Connection{" + id + ", active=" + isActive + "}";
        }
    }

    // PRIVATE constructor - singleton
    private DatabaseConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        initializePool();
    }

    /**
     * Get singleton pool instance
     */
    public static synchronized DatabaseConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            instance = new DatabaseConnectionPool(poolSize);
        }
        return instance;
    }

    /**
     * Get singleton pool (if already initialized)
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
        System.out.println("🔄 Initializing Connection Pool with " + poolSize + " connections...");
        for (int i = 1; i <= poolSize; i++) {
            Connection conn = new Connection("DB-Conn-" + i);
            availableConnections.add(conn);
        }
        System.out.println("✅ Pool initialized successfully\n");
    }

    /**
     * Borrow a connection from the pool
     */
    public synchronized Connection borrowConnection() {
        if (availableConnections.isEmpty()) {
            System.out.println("❌ No available connections! Please wait or increase pool size.");
            return null;
        }

        Connection conn = availableConnections.remove(0);
        usedConnections.add(conn);
        System.out.println("📤 Borrowed: " + conn.getId());
        printStats();
        return conn;
    }

    /**
     * Return a connection to the pool
     */
    public synchronized void returnConnection(Connection conn) {
        if (conn == null)
            return;

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
}