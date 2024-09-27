package chapter_13;

import java.util.concurrent.*;

public class CheckResultWithConcurrencyAPI {
    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException {
        var executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = executorService.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
            });

            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!");
        } catch (TimeoutException | InterruptedException e) {
            System.out.println(" Not reached on time!");
        } finally {
            executorService.shutdown();
        }
    }
}

