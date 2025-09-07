package lld1.threads.creatingThread;

public class Print implements Runnable {
    @Override
    public void run() {// contains task we want to run in seperate thread
        System.out.println("This is Printed by: " + Thread.currentThread().getName() + " Thread");
    }

}
