package lld1.threads.withoutSemaphore;

import java.util.Queue;

public class ConsumerWS implements Runnable {

    Queue<Integer> store;
    String name;

    public ConsumerWS(Queue<Integer> store, String name) {
        this.store = store;
        this.name = name;
    }

    public void run() {

        while (true) {
            if (store.size() > 0) {
                System.out.println(store.size() + " - Consumed by: " + name);
                store.remove();
            }
        }

    }
}