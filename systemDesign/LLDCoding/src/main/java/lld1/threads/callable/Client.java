package lld1.threads.callable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) {
        System.out.println("This is Printed by: " + Thread.currentThread().getName() + " Thread at start");
        List<Integer> arr = List.of(2, 6, 3, 7, 1, 9, 8, 10);

        ExecutorService executorService = Executors.newCachedThreadPool();
        // we are passeing executorService to MergeSort constructor so that we can use
        // the same
        // executorService object in recursive calls of MergeSort. o it will create only
        // one thread pool
        // otherwise in each recursive call new thread pool will be created if we create
        // executorservise
        // inside our recursive function which is not desired
        MergeSort ms = new MergeSort(arr, executorService);
        // created an object of print class which implements runnable interface
        // as of now no new thread is created as we are just creating object and calling
        // the call method where main logic is written
        List<Integer> sortedList1 = ms.call();
        System.out.println(sortedList1 + " printed by: " + Thread.currentThread().getName() + " Thread of call at end");// by
                                                                                                                        // main
                                                                                                                        // thread
        System.out.println("---------------------------------------------");

        // to actually create a new thread we need to pass this object to
        // executorService
        // constructor in place of above line

        Future<List<Integer>> sortedListFuture = executorService.submit(ms);
        List<Integer> sortedList2 = null;
        try {
            sortedList2 = sortedListFuture.get();
            System.out.println(
                    sortedList2 + " printed by: " + Thread.currentThread().getName() + " Thread of executor at end");// by
                                                                                                                     // main
                                                                                                                     // thread
        } catch (InterruptedException | java.util.concurrent.ExecutionException e) {
            e.printStackTrace();
        }
    }
}
