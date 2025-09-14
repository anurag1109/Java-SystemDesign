package lld1.threads.withoutSemaphore;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
    public static void main(String[] args) {

        Queue<Integer> store = new LinkedList<>();
        int maxSize = 5;

        // creating multiple thread and each thread is trying to access the same store
        ProducerWS p1 = new ProducerWS(store, "p1", maxSize);
        ProducerWS p2 = new ProducerWS(store, "p2", maxSize);
        ProducerWS p3 = new ProducerWS(store, "p3", maxSize);
        ProducerWS p4 = new ProducerWS(store, "p4", maxSize);
        ProducerWS p5 = new ProducerWS(store, "p5", maxSize);

        ConsumerWS c1 = new ConsumerWS(store, "c1");
        ConsumerWS c2 = new ConsumerWS(store, "c2");
        ConsumerWS c3 = new ConsumerWS(store, "c3");
        ConsumerWS c4 = new ConsumerWS(store, "c4");
        ConsumerWS c5 = new ConsumerWS(store, "c5");

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();
        Thread t4 = new Thread(p4);
        t4.start();
        Thread t5 = new Thread(p5);
        t5.start();

        Thread t6 = new Thread(c1);
        t6.start();
        Thread t7 = new Thread(c2);
        t7.start();
        Thread t8 = new Thread(c3);
        t8.start();
        Thread t9 = new Thread(c4);
        t9.start();
        Thread t10 = new Thread(c5);
        t10.start();

    }

}
