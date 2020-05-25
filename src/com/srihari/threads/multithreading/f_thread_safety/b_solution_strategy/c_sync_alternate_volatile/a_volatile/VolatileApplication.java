package com.srihari.threads.multithreading.f_thread_safety.b_solution_strategy.c_sync_alternate_volatile.a_volatile;

public class VolatileApplication {
    public static void main(String[] args) {
        var status = new DownloadStatus();

        Thread thread1 = new Thread(new DownloadFileTask(status));
        Thread thread2 = new Thread(() -> {
            // It wastes CPU cycles
            while(!status.isDone()) {}      // it waits for status to be done
                                            // but since status is cached in local memory of thread, the status set to done by other thread is not vsble here
                                            // Hence this while loop run infinitely
                                            // To resolve this, we will use volatile for 'done' field
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
