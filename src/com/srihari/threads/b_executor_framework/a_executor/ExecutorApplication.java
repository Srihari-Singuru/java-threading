package com.srihari.threads.b_executor_framework.a_executor;

import java.util.concurrent.Executors;

/**
 * ExecutorService will simplify the Thread creation, termination etc
 * but it doesn't solve the concurrency issues
 */
public class ExecutorApplication {
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(4); // We can have fixed, scheduled, cached etc thread pools

        try {
            // The thread will be allocated from the pool of 4 threads
            executor.submit(() -> System.out.println(Thread.currentThread().getName()));

            // if we submit 10 tasks, even then the threads will be allocated from pool of 4 threads defined
            for (int i = 0; i < 10; i++) {
                executor.submit(() -> System.out.println(Thread.currentThread().getName()));
            }
        }
        finally {
            executor.shutdown();    // Doesn't stop the current task, and it waits for the current task to complete, and doesn't accept new tasks
            //executor.shutdownNow();  // It terminates the current task as well
        }
    }
}
