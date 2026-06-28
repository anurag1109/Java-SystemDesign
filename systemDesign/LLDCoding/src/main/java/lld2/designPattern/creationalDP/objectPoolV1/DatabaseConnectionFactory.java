package lld2.designPattern.creationalDP.objectPoolV1;

/**
 * Concrete factory for creating database connections
 */
public class DatabaseConnectionFactory implements ObjectFactory {
    @Override
    public Poolable create(int index) {
        return new DatabaseConnection("Conn-" + index);
    }
}