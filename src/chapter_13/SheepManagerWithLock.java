package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.locks.ReentrantLock;

public class SheepManagerWithLock {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void incrementAndReport() {
        lock.lock();
        try {
            System.out.print((++counter) + " ");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        SheepManagerWithLock manager = new SheepManagerWithLock();

        try {
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
