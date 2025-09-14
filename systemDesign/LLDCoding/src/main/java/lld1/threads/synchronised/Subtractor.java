package lld1.threads.synchronised;

public class Subtractor implements Runnable {
    Count cnt;

    public Subtractor(Count cnt) {
        this.cnt = cnt;
    }

    public void run() {
        // lock.lock();

        for (int i = 0; i < 10000; i++) {
            synchronized (cnt) {
                cnt.cnt -= i;
            }
        }
        // lock.unlock();
    }

}
