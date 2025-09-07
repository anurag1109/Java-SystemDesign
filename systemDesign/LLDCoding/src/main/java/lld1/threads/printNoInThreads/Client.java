package lld1.threads.printNoInThreads;

public class Client {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            PrintNo p = new PrintNo(i);
            Thread t1 = new Thread(p);
            t1.start();
        }
    }

}
