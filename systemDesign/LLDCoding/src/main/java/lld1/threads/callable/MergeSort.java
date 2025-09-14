package lld1.threads.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;

public class MergeSort implements Callable<List<Integer>> {// implements callable interface
    List<Integer> arr;
    ExecutorService executorService;

    public MergeSort(List<Integer> arr, ExecutorService executorService) {
        this.arr = arr;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() {
        System.out.println(" printed by: " + Thread.currentThread().getName() + " Thread inside call");// by
                                                                                                       // pool-1-thread-n
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        List<Integer> left = arr.subList(0, mid);
        List<Integer> right = arr.subList(mid, arr.size());

        // In oder to call recursively we need to create new objects of MergeSort
        MergeSort leftSorter = new MergeSort(left, executorService);
        MergeSort rightSorter = new MergeSort(right, executorService);

        // will not create new threads only main thread will be used
        // List<Integer> sortedLeft = leftSorter.call();
        // List<Integer> sortedRight = rightSorter.call();

        // for new thread pass it to executorService
        ExecutorService executorService1 = Executors.newCachedThreadPool();// create new threadpool for right half

        Future<List<Integer>> sortedLeftFuture = executorService.submit(leftSorter);// use the same threadpool for left
                                                                                    // half pool-1 thread-n
        Future<List<Integer>> sortedRightFuture = executorService1.submit(rightSorter);// use different threadpool for
                                                                                       // right half pool-n thread-1
        List<Integer> sortedLeft = null;
        List<Integer> sortedRight = null;
        try {
            sortedLeft = sortedLeftFuture.get();
            sortedRight = sortedRightFuture.get();
        } catch (InterruptedException | java.util.concurrent.ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>(); // or handle error as needed
        }

        int i = 0, j = 0;
        List<Integer> merged = new ArrayList<>();
        while (i < sortedLeft.size() && j < sortedRight.size()) {
            if (sortedLeft.get(i) <= sortedRight.get(j)) {
                merged.add(sortedLeft.get(i));
                i++;
            } else {
                merged.add(sortedRight.get(j));
                j++;
            }
        }

        while (i < sortedLeft.size()) {
            merged.add(sortedLeft.get(i));
            i++;
        }
        while (j < sortedRight.size()) {
            merged.add(sortedRight.get(j));
            j++;
        }
        return merged;

    }

}
