package lld2.designPattern.creationalDP.singelton.doubleCheckLocking;

public class DBConnection {
    private static DBConnection instance = null;

    // constructor private
    private DBConnection() {

    }

    public static DBConnection createInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {// class level lock
                // synchronized (instance) { // this will give null pointer exception if
                // instance is null
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

}
