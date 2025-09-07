package lld1.threads.creatingThread;

public class Client {

    public static void main(String[] args) {
        System.out.println("This is Printed by: " + Thread.currentThread().getName() + " Thread at start");
        Print p = new Print();// create an object of print class which implements runnable interface
        Thread t1 = new Thread(p);// create a thread and pass the object of print class to it
        t1.start();// start the thread, which calls the run() method of print class
        System.out.println("This is Printed by: " + Thread.currentThread().getName() + " Thread at end");
    }
}
