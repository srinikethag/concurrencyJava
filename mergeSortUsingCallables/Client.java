package mergeSortUsingCallables;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> data = List.of(6, 4, 5, 2, 1, 10, 8);

        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSort mergeSort = new MergeSort(data, executorService);
        Future<List<Integer>> sortedDataFuture = executorService.submit(mergeSort);

        List<Integer> sortedData = sortedDataFuture.get();// Blocking call -> Thread waits until the results are ready

        System.out.println("Sorted data is:- " + sortedData);

        executorService.shutdown();
    }
}
