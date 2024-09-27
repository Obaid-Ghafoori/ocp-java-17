package chapter_13;

/**
 * Creates a new thread that increments a counter variable, and waits for the counter to reach a certain value.
 */
public class CheckResultsWithSleep {
    private static int counter = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
             counter++;
            }
        }).start();

        // Wait for the counter to reach 1,000,000
        while (counter < 1_000_000) {
            System.out.println("Thread is not reached yet!");
            try {
                // Sleep for 1 second,
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                // Throw a RuntimeException if the thread is interrupted while sleeping
                throw new RuntimeException("Interrupted!" + e);
            }
        }

        System.out.println("Reached:  " + counter);
    }
}
