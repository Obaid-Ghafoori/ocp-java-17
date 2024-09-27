package chapter_13;

public class Concurrency {
    public static void main(String[] args) {
        System.out.println("Welcome Chapter_13");

        Thread job = new Thread(() -> {
            try {
                Zoo.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        job.start();
        System.out.println("Main method finished its task!");
    }
}
