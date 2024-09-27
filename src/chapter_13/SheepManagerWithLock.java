package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SheepManagerWithLock {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void incrementAndReport() {
        try {
            if(lock.tryLock(100, TimeUnit.MILLISECONDS)){
                try {
                    System.out.print((++counter) + " ");
                    System.out.println("Lock obtained, entering protecting coding block");
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println(" Unable to acquire lock, doing something else at the moment");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
