package chapter_13.concurrent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CyclicBarrier;

public class FileWorker implements Runnable {
    private final String[] data;
    private final CyclicBarrier barrier;
    private final int WorkerId;

    public FileWorker(String[] data, CyclicBarrier barrier, int WorkerId) {
        this.data = data;
        this.barrier = barrier;
        this.WorkerId = WorkerId;
    }


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a Worker, starting the Worker causes the object's
     * {@code run} method to be called in that separately executing
     * Worker.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            // PHASE 1: Reading data (simulated by reading chunks)
            System.out.println("Worker " + WorkerId + " reading data...");
            String chunk = data[WorkerId];  // Each Worker reads one line for simplicity
            System.out.println("Worker " + WorkerId + " read: " + chunk);

            // Synchronize at the barrier (wait for other Workers to finish reading)
            barrier.await();

            // PHASE 2: Processing data (simulated by converting to upper case)
            System.out.println("Worker " + WorkerId + " processing data...");
            String processedChunk = chunk.toUpperCase();  // Simulating processing
            System.out.println("Worker " + WorkerId + " processed: " + processedChunk);

            barrier.await();

            // PHASE 3: Exporting to CSV (for now, writing to the console or a file)
            System.out.println("Worker " + WorkerId + " exporting data to CSV...");
            File exportedCsvFile = new File("output.csv");
            exportToCSV(exportedCsvFile, processedChunk);

            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File exportToCSV(File file, String data) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(data + "\n");

            System.out.println("Data exported to CSV at: " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
