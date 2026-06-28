package lld2.designPattern.creationalDP.objectPoolWithSingletonV2;

/**
 * DatabaseConnection with PRIVATE constructor
 * Can ONLY be created by the pool, not directly
 */
public class SingletonDatabaseConnection {
    private final String id;
    private String query;
    private boolean isActive;

    // PRIVATE constructor - cannot instantiate directly!
    private SingletonDatabaseConnection(String id) {
        this.id = id;
        this.query = "";
        this.isActive = false;
    }

    // Only the pool can create instances (package-private factory method)
    static SingletonDatabaseConnection create(String id) {
        return new SingletonDatabaseConnection(id);
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