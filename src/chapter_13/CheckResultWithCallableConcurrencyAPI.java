package chapter_13;

import java.util.concurrent.*;

public class CheckResultWithCallableConcurrencyAPI {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var service = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = service.submit(() -> 30 + 12);
            System.out.println("Result: " + result.get()); // 42
        } finally {
            service.shutdown();
        }
    }
}

