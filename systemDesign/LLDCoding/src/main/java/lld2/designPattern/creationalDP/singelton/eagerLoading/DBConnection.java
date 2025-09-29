package lld2.designPattern.creationalDP.singelton.eagerLoading;

public class DBConnection {
    private static DBConnection instance = new DBConnection();

    // constructor private
    private DBConnection() {

    }

    public static DBConnection createInstance() {
        return instance;
    }
    // problem here is if this class is not used still object will be created and it
    // will slow the performance when app starts but this is thread safe
    // also we cannot pass any parameter to constructor
}
