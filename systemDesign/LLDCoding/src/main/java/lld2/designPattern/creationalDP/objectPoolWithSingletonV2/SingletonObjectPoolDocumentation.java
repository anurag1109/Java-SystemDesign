package lld2.designPattern.creationalDP.objectPoolWithSingletonV2;

/**
 * ========================================================================
 * SINGLETON + OBJECT POOL PATTERN - COMPREHENSIVE DOCUMENTATION
 * ========================================================================
 *
 * 1. WHY COMBINE SINGLETON WITH OBJECT POOL?
 * -------------------------------------------
 * Problem with basic Object Pool:
 *   ✗ Users can still create objects directly: new DatabaseConnection()
 *   ✗ Multiple pool instances can be created
 *   ✗ No enforcement of pool usage
 *
 * Solution: Combine with Singleton pattern
 *   ✓ Private constructors prevent direct instantiation
 *   ✓ Only ONE pool instance in entire application
 *   ✓ All resources must go through the pool
 *   ✓ Complete resource control
 *
 *
 * 2. KEY COMPONENTS
 * -----------------
 *
 * a) SingletonDatabaseConnection:
 *    - PRIVATE constructor (cannot instantiate directly)
 *    - Static factory method create() for internal pool use only
 *    - Has reset() method for reuse
 *
 *    Code:
 *    private DatabaseConnection(String id) { ... } // PRIVATE
 *    static DatabaseConnection create(String id) { // PACKAGE-PRIVATE
 *        return new DatabaseConnection(id);
 *    }
 *
 * b) DatabaseConnectionPool (SINGLETON):
 *    - PRIVATE constructor
 *    - Static getInstance() method for singleton access
 *    - Manages borrowing/returning connections
 *    - Only ONE instance ever created
 *
 *    Code:
 *    private static DatabaseConnectionPool instance;
 *    
 *    public static synchronized DatabaseConnectionPool getInstance(int size) {
 *        if (instance == null) {
 *            instance = new DatabaseConnectionPool(size);
 *        }
 *        return instance;
 *    }
 *
 *
 * 3. FLOW OF EXECUTION
 * ---------------------
 *
 * First Call:
 * DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(3)
 *   → instance is null
 *   → Create new pool with 3 connections
 *   → Initialize available connections
 *   → Return instance
 *
 * Subsequent Calls:
 * DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance(5)
 *   → instance already exists
 *   → Ignore the parameter (5)
 *   → Return same instance
 *
 * Result: Both pool and pool2 reference THE SAME object!
 *
 *
 * 4. WHAT YOU CANNOT DO (ENFORCEMENT)
 * -----------------------------------
 *
 * ❌ Cannot create connection directly:
 *    DatabaseConnection conn = new DatabaseConnection("id");
 *    ERROR: private constructor
 *
 * ❌ Cannot create multiple pools:
 *    DatabaseConnectionPool pool1 = new DatabaseConnectionPool(3);
 *    ERROR: private constructor
 *
 * ❌ Cannot bypass the pool:
 *    // All connections come from pool only
 *
 *
 * 5. WHAT YOU CAN DO (ALLOWED PATTERNS)
 * ----------- ----------------------------
 *
 * ✓ Get the singleton pool:
 *    DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(3);
 *
 * ✓ Borrow from pool:
 *    DatabaseConnection conn = pool.borrowConnection();
 *
 * ✓ Use connection:
 *    conn.executeQuery("SELECT * FROM users");
 *
 * ✓ Return to pool:
 *    pool.returnConnection(conn);
 *
 *
 * 6. ADVANTAGES
 * ---------------
 * ✓ Enforced Pool Usage: Impossible to bypass pool
 * ✓ Single Resource Control: One pool manages all connections
 * ✓ No Resource Leaks: Cannot create unlimited objects
 * ✓ Global Access: getInstance() available everywhere
 * ✓ Consistent Behavior: All code uses same pool
 * ✓ Thread-Safe: Synchronized getInstance() method
 *
 *
 * 7. DISADVANTAGES
 * -------------------
 * ✗ Global State: Application-wide dependency
 * ✗ Testing Difficult: Hard to reset in tests
 * ✗ Thread Synchronization: Lock on getInstance()
 * ✗ Inflexibility: Cannot easily swap implementations
 *
 *
 * 8. SINGLETON VS OBJECT POOL
 * ----------------------------
 *
 * Singleton ALONE:
 *   - One shared instance
 *   - Blocks concurrent access
 *   - Example: Logger
 *
 * Object Pool ALONE:
 *   - Multiple reusable instances
 *   - Allows concurrency
 *   - But can be bypassed
 *
 * Singleton + Object Pool:
 *   - Multiple instances in one pool
 *   - Enforced through singleton pool
 *   - Cannot be bypassed
 *   - Allows concurrency through pool
 *   - Best of both worlds!
 *
 *
 * 9. REAL-WORLD EXAMPLES
 * -------------------------
 *
 * Database Connection Pool:
 * ├── Singleton HikariCP pool
 * ├── Multiple DB connections inside
 * ├── Cannot create connections directly
 * └── All code shares same pool
 *
 * Thread Pool (ExecutorService):
 * ├── Single shared executor
 * ├── Multiple worker threads inside
 * ├── Cannot create threads directly
 * └── All tasks use same pool
 *
 * Cache Pool:
 * ├── Singleton cache manager
 * ├── Multiple cache objects
 * ├── Controlled allocation
 * └── Prevents memory exhaustion
 *
 *
 * 10. THREAD SAFETY CONSIDERATIONS
 * -----------------------------------
 *
 * getInstance() is synchronized:
 *   public static synchronized DatabaseConnectionPool getInstance() {
 *       if (instance == null) {
 *           instance = new DatabaseConnectionPool(poolSize);
 *       }
 *       return instance;
 *   }
 *
 * borrowConnection() is synchronized:
 *   public synchronized SingletonDatabaseConnection borrowConnection() {
 *       // Remove from available
 *       // Add to used
 *   }
 *
 * returnConnection() is synchronized:
 *   public synchronized void returnConnection(...) {
 *       // Remove from used
 *       // Add to available
 *   }
 *
 * Benefits:
 *   ✓ Thread-safe access to pool
 *   ✓ No race conditions
 *   ✓ Atomic operations
 *
 *
 * 11. USAGE PATTERN
 * ------------------
 *
 * // Initialize pool once in application startup
 * DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(10);
 *
 * // Use anywhere in application
 * class UserService {
 *     public void getUser(int id) {
 *         DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
 *         SingletonDatabaseConnection conn = pool.borrowConnection();
 *         try {
 *             conn.executeQuery("SELECT * FROM users WHERE id = " + id);
 *         } finally {
 *             pool.returnConnection(conn);
 *         }
 *     }
 * }
 *
 *
 * 12. COMPARISON WITH BASIC OBJECT POOL
 * ----------------------------------------
 *
 * Basic Pool:
 *   ObjectPool pool1 = new ObjectPool(factory, 3);
 *   ObjectPool pool2 = new ObjectPool(factory, 3);
 *   // Now you have 6 total connections!
 *
 * Singleton Pool:
 *   DatabaseConnectionPool pool1 = getInstance(3);
 *   DatabaseConnectionPool pool2 = getInstance(3);
 *   // Still only 3 total connections (same instance)
 *
 *
 * ========================================================================
 */
public class SingletonObjectPoolDocumentation {
    // Documentation class
}