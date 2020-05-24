package com.srihari.threads.multithreading.racecondition.solution.confinement;

import java.util.ArrayList;
import java.util.List;

public class RaceConditionApplication {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        // join all the above started threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalBytes =
                tasks.stream()
                .map(task -> task.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        // Now, we will get 100_000 bytes as response
        System.out.println(totalBytes);
    }
}
