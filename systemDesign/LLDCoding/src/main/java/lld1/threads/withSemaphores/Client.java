package lld1.threads.withSemaphores;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {

        Queue<Integer> store = new LinkedList<>();
        int maxSize = 5;
        Semaphore smProducer = new Semaphore(maxSize);
        Semaphore smConsumer = new Semaphore(0);
        // creating multiple thread and each thread is trying to access the same store
        // but with semaphore to control the access
        Producer p1 = new Producer(store, "p1", maxSize, smProducer, smConsumer);
        Producer p2 = new Producer(store, "p2", maxSize, smProducer, smConsumer);
        Producer p3 = new Producer(store, "p3", maxSize, smProducer, smConsumer);
        Producer p4 = new Producer(store, "p4", maxSize, smProducer, smConsumer);
        Producer p5 = new Producer(store, "p5", maxSize, smProducer, smConsumer);

        Consumer c1 = new Consumer(store, "c1", smProducer, smConsumer);
        Consumer c2 = new Consumer(store, "c2", smProducer, smConsumer);
        Consumer c3 = new Consumer(store, "c3", smProducer, smConsumer);
        Consumer c4 = new Consumer(store, "c4", smProducer, smConsumer);
        Consumer c5 = new Consumer(store, "c5", smProducer, smConsumer);

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
