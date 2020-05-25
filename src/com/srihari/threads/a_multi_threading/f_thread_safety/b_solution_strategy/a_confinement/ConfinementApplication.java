package com.srihari.threads.a_multi_threading.f_thread_safety.b_solution_strategy.a_confinement;

import java.util.ArrayList;
import java.util.List;

/**
 * Confinement is like, every thread should have it's own 'DownloadStatus' instance
 * at the end, the main thread can combine the results
 */
public class ConfinementApplication {
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
