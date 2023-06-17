package org.soneech.question36;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Callable<Integer>> tasks = new ArrayList<>();

        tasks.add(() -> 1);
        tasks.add(() -> 2);
        tasks.add(() -> 3);

        try {  // invokeAll example
            List<Future<Integer>> results = executorService.invokeAll(tasks);
            for (Future<Integer> result : results) {
                System.out.println(result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
