package lld1.threads.withSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    Queue<Integer> store;
    String name;
    int maxSize;
    Semaphore smProducer;
    Semaphore smConsumer;

    public Producer(Queue<Integer> store, String name, int maxSize, Semaphore smProducer, Semaphore smConsumer) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
        this.smProducer = smProducer;
        this.smConsumer = smConsumer;
    }

    public void run() {

        while (true) {
            try {
                smProducer.acquire();
                System.out.println(store.size() + " - Produced by: " + name);
                store.add(1);
                smConsumer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
