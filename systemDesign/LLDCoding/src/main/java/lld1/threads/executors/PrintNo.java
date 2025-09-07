package lld1.threads.executors;

public class PrintNo implements Runnable {
      int n;

    PrintNo(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ===> " + n);
    }

}
