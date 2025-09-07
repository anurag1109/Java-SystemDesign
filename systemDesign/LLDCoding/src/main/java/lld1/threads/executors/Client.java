package lld1.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();// dynamically creates threads as needed and reuses previously constructed threads when they are available.
        // ExecutorService executorService = Executors.newSingleThreadExecutor();// creates a single worker thread to process tasks sequentially.
        for (int i = 1; i <= 100; i++) {
            PrintNo p = new PrintNo(i);
            executorService.execute(p);
        }
    }

}
