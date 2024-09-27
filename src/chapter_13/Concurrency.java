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

        /** a deamon thread is the one that will not prevent JVM from exiting the program to finishes.
         *  application will terminate when only threads that running are deamon thread. e.g. setting thread will not
         *  print out the statement inside the pause.
         */
        job.setDaemon(true);
        job.start();
        System.out.println("Main method finished its task!");
    }
}
