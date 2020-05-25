package com.srihari.threads.b_executor_framework.d_case_study.c_getting_many_quotes;

public class LongRunningTask {
    public static void simulateLongRunningTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
