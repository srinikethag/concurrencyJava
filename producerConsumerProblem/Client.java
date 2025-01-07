package producerConsumerProblem;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Shirt> store = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        int maxSizeOfStore = 6;
        Semaphore producerSemaphore = new Semaphore(maxSizeOfStore);
        Semaphore consumerSemaphore = new Semaphore(0);

        executorService.submit(new Producer("P1", store, producerSemaphore, consumerSemaphore));
        executorService.submit(new Producer("P2", store, producerSemaphore, consumerSemaphore));
        executorService.submit(new Producer("P3", store, producerSemaphore, consumerSemaphore));

        executorService.submit(new Consumer("C1", store, producerSemaphore, consumerSemaphore));
        executorService.submit(new Consumer("C2", store, producerSemaphore, consumerSemaphore));
        executorService.submit(new Consumer("C3", store, producerSemaphore, consumerSemaphore));
        executorService.submit(new Consumer("C4", store, producerSemaphore, consumerSemaphore));
        executorService.submit(new Consumer("C5", store, producerSemaphore, consumerSemaphore));

        executorService.shutdown();
    }
}