package com.srihari.threads.b_executor_framework.c_completable_future.i_waiting_first;

public class LongRunningTask {
    public static void simulateLongRunningTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
