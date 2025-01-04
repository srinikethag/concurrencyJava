package numberPrinterUsingThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {


        // with cached thread pools
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            for (int i = 0; i < 100; i++) {

                numberPrinterUsingThreadPools np = new numberPrinterUsingThreadPools(i);
                executorService.submit(np);
            }

            executorService.shutdown();
        }

        // with fixed thread pools
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {

            numberPrinterUsingThreadPools np2 = new numberPrinterUsingThreadPools(i);
            executorService2.submit(np2);
        }

        executorService2.shutdown();


    }
}
