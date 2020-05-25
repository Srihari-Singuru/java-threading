package com.srihari.threads.b_executor_framework.d_case_study.b_getting_quote;

public class LongRunningTask {
    public static void simulateLongRunningTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
