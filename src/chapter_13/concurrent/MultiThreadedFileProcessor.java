package chapter_13.concurrent;

import java.util.concurrent.CyclicBarrier;

public class MultiThreadedFileProcessor {
    public static void main(String[] args) {
        //  number of workers
        int numberOfThread = 3;

        var cyclicBarrier = new CyclicBarrier(numberOfThread, () -> {
            System.out.println("All workers reached the barrier. Moving to the next phase...\n");
        });

        simulateLargeData();

        handelWork(numberOfThread, cyclicBarrier);

    }

    private static void handelWork(int numberOfThread, CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < numberOfThread; i++) {
            new Thread(new FileWorker(simulateLargeData(), cyclicBarrier, i)).start();
        }
    }

    private static String[] simulateLargeData() {
        String[] data = {
                "Line 1: Some data",
                "Line 2: Some data",
                "Line 3: Some data",
                "Line 4: Some data",
                "Line 5: Some data"
        };
        return data;
    }
}
