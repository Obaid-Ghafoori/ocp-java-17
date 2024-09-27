package chapter_13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
    private int counter =0;

    private void incrementAndReport(){
        System.out.print((++counter) + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        try {
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() ->manager.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}

class SheepManagerWithAtomicInteger{
    private AtomicInteger counter = new AtomicInteger(0);

    public void incrementAndReport(){
        System.out.print(counter.incrementAndGet()+ "- ");
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        try {
            var manager = new SheepManagerWithAtomicInteger();
            for (int i = 0; i < 10; i++) {

                service.submit(() ->manager.incrementAndReport());

            }
        } finally {
            service.shutdown();
        }
    }
}
