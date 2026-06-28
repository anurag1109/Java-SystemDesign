package lld2.designPattern.creationalDP.objectPoolV1;

/**
 * Concrete poolable object - represents a database connection
 */
public class DatabaseConnection implements Poolable {
    private final String id;
    private String query;
    private boolean isActive;

    public DatabaseConnection(String id) {
        this.id = id;
        this.query = "";
        this.isActive = false;
    }

    public void executeQuery(String sql) {
        this.isActive = true;
        this.query = sql;
        System.out.println("[" + id + "] Executing: " + sql);
    }

    @Override
    public void reset() {
        this.query = "";
        this.isActive = false;
        System.out.println("[" + id + "] Connection reset");
    }

    @Override
    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Connection{" + id + ", active=" + isActive + "}";
    }
}