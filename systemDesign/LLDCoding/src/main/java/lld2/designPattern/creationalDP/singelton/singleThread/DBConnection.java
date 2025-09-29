package lld2.designPattern.creationalDP.singelton.singleThread;

public class DBConnection {
    private static DBConnection instance = null;

    // constructor private
    private DBConnection() {

    }

    public static DBConnection createInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    // problem with this code is if multiple thread access this method at the same
    // time it will create multiple instances
}
