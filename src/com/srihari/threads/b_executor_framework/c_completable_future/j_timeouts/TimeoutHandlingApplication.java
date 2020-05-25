package com.srihari.threads.b_executor_framework.c_completable_future.j_timeouts;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TimeoutHandlingApplication {
    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> {
            LongRunningTask.simulateLongRunningTask();
            return 10;
        });

        try {
            var result = future
                            .completeOnTimeout(5, 2, TimeUnit.SECONDS)  // timesout after 2 sec, and returns the value 5
                            .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
