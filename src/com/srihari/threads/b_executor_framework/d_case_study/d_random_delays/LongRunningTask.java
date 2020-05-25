package com.srihari.threads.b_executor_framework.d_case_study.d_random_delays;

public class LongRunningTask {
    public static void simulateLongRunningTask() {
        simulateLongRunningTask(5000);
    }

    public static void simulateLongRunningTask(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
