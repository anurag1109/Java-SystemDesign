package lld1.threads.withoutSemaphore;

import java.util.Queue;

public class ProducerWS implements Runnable {

    Queue<Integer> store;
    String name;
    int maxSize;

    public ProducerWS(Queue<Integer> store, String name, int maxSize) {
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
    }

    public void run() {

        while (true) {
            if (store.size() < maxSize) {
                System.out.println(store.size() + " - Produced by: " + name);
                store.add(1);
            }
        }

    }
}
