package lld1.threads.atomicTnteger;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Count cnt;
    Lock lock;

    public Adder(Count cnt, Lock lock) {
        this.cnt = cnt;
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        for (int i = 0; i < 10000; i++) {
            cnt.counter.addAndGet(i);
        }
        lock.unlock();
    }

}
