package lld1.threads.mutex;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    Count cnt;
    Lock lock;

    public Subtractor(Count cnt, Lock lock) {
        this.cnt = cnt;
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        for (int i = 0; i < 10000; i++) {
            cnt.cnt -= i;
        }
        lock.unlock();
    }

}
