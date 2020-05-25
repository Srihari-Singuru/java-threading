package com.srihari.threads.b_executor_framework.c_completable_future.b_asynchronous_api;

public class LongRunningTask {
    public static void simulateLongRunningTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
