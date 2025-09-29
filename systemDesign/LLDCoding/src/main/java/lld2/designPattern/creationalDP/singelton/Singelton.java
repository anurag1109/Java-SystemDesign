package lld2.designPattern.creationalDP.singelton;

import lld2.designPattern.creationalDP.singelton.singleThread.DBConnection;

public class Singelton {

    public static void main(String[] args) {

        // usase
        DBConnection db1 = DBConnection.createInstance();
        DBConnection db2 = DBConnection.createInstance();
        System.out.println(db1 == db2); // true

    }
}
