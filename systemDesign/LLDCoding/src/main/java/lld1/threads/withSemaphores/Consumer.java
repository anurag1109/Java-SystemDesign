package lld1.threads.withSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    Queue<Integer> store;
    String name;
    Semaphore smProducer;
    Semaphore smConsumer;

    public Consumer(Queue<Integer> store, String name, Semaphore smProducer, Semaphore smConsumer) {
        this.store = store;
        this.name = name;
        this.smProducer = smProducer;
        this.smConsumer = smConsumer;
    }

    public void run() {

        while (true) {
            try {
                smConsumer.acquire();
                // If there is nothing to acquire on line 24 (smConsumer.acquire();),
                // the consumer thread will block and wait until a permit becomes available.
                // so even if consumer thread will start first, it will wait until producer
                // produce something and release the permit
                System.out.println(store.size() + " - Consumed by: " + name);
                store.remove();
                smProducer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}