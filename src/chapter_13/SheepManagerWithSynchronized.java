package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * In this class, the incrementAndReport() method is declared as synchronized, which means that only one thread can access
 * this method at a time. This ensures that the counter variable is incremented atomically, and the output is correct.
 */
public class SheepManagerWithSynchronized {
    private int counter = 0;

    public synchronized void incrementAndReport() {
        System.out.print((++counter) + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        SheepManagerWithSynchronized manager = new SheepManagerWithSynchronized();

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
