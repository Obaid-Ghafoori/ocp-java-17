package chapter_13;

/**
 * Creates a new thread that increments a counter variable, and waits for the counter to reach a certain value.
 */
public class CheckResultsWithSleepAndInterrupt {
    private static int counter = 0;

    public static void main(String[] args) {
        final var mainThread = Thread.currentThread();

        new Thread(() -> {
            for (int i = 0; i < 1_000; i++) {
                counter++;
            }
            // Interrupt the main thread after the counter has reached 1,000,000
            mainThread.interrupt();
        }).start();

        // Wait for the counter to reach 1,000,000
        while (counter < 1_000_00) {
            System.out.println("Thread is not reached yet!");
            try {
                // Sleep for 1 second
                Thread.sleep(1_000_00);
            } catch (InterruptedException e) {
                // Handle the InterruptedException instead of throwing a RuntimeException
                System.out.println("Main thread is interrupted!");
            }
        }

        System.out.println("Reached:  " + counter);
    }
}