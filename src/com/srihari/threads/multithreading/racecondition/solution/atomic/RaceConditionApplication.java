package com.srihari.threads.multithreading.racecondition.solution.atomic;

import java.util.ArrayList;
import java.util.List;

public class RaceConditionApplication {
    public static void main(String[] args) {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        // join all the above started threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Ideally we should see 100 thousand bytes (10 threads * 10_000 bytes) as response here
        // but, due to race condition, we won't see that number as output
        System.out.println(status.getTotalBytes());
    }
}
