package chapter_13.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class MultiThreadedFileProcessor {
    public static void main(String[] args) {
        //  number of workers
        int numberOfThread = 3;

        var cyclicBarrier = new CyclicBarrier(numberOfThread, () ->
                System.out.println("All workers reached the barrier. Moving to the next phase...\n"));

        simulateLargeData();

        handelWork(numberOfThread, cyclicBarrier);

        copyWriteList();

    }

    private static void copyWriteList() {
        CopyOnWriteArrayList<Integer> favNum = new CopyOnWriteArrayList<>(List.of(4, 3, 42));
        System.out.println("printing CopyOnWriteArrayList-----------------");
        // ArrayList<Integer> favNum = new ArrayList<>(List.of(4, 3, 42)); if this added instead of CopyOnWriteArrayList it will throw ConcurrentModificationException
        System.out.println("printing CopyOnWriteArrayList-----------------");

            var data = List.of(List.of(1,2), List.of(2,3), List.of(4,5));
            data.parallelStream().flatMap(s -> s.stream()).findFirst()
                    .ifPresent(System.out::println);
        System.out.println("--------------------------");

        var data1 = List.of(List.of(1,2), List.of(2,3), List.of(4,5));
        data1.stream().flatMap(s -> s.stream()).findFirst()
                .ifPresent(System.out::println);
        System.out.println("--------------------------");

        for (var n : favNum) {
            System.out.print(n + "-");
            favNum.add(n + 1);
        }
        System.out.print("\nAFTER: ");
        favNum.forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Size: " + favNum.size());
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
