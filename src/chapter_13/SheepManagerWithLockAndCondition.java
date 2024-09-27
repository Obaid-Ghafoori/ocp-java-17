package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SheepManagerWithLockAndCondition {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition counterReached = lock.newCondition();

    public void incrementAndReport() {
        lock.lock();
        try {
            System.out.print((++counter) + " ");
            if (counter == 10) {
                counterReached.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitForCounterToReach10() throws InterruptedException {
        lock.lock();
        try {
            while (counter < 10) {
                counterReached.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(20);
        SheepManagerWithLockAndCondition manager = new SheepManagerWithLockAndCondition();

        service.submit(() -> {
            try {
                manager.waitForCounterToReach10();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        for (int i = 0; i < 10; i++) {
            service.submit(() -> manager.incrementAndReport());
        }
        System.out.println(" end of SheepManagerWithLockAndCondition");
        service.shutdown();
    }
}
