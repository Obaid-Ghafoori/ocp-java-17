package chapter_13;

public class Zoo {
    public static void pause() throws InterruptedException {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new InterruptedException("Error:" + e);
        }
        System.out.println("Thread finished!");
    }
}
