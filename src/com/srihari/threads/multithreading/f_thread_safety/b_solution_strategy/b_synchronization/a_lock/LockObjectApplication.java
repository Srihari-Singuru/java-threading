package com.srihari.threads.multithreading.f_thread_safety.b_solution_strategy.b_synchronization.a_lock;

import java.util.ArrayList;
import java.util.List;

public class LockObjectApplication {
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

        // We will get 100_000 as we are locking in the increment operation
        System.out.println(status.getTotalBytes());
    }
}
