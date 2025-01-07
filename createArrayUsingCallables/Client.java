package createArrayUsingCallables;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // Create an ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create an instance of ArrayCreator
        ArrayCreator arrayCreator = new ArrayCreator(n);

        // Submit the ArrayCreator to the executor and get a Future
        Future<List<Integer>> future = executor.submit(arrayCreator);

        try {
            // Get the result from the Future (this will block until the result is available)
            List<Integer> resultList = future.get();

            // Print the ArrayList
            System.out.println(resultList);

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error getting result from Callable: " + e.getMessage());
            e.printStackTrace(); // Print the full stack trace for debugging
        } finally {
            // Important: Shutdown the executor to release resources
            executor.shutdown();
        }
    }
}
