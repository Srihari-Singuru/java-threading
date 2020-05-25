package com.srihari.threads.b_executor_framework.c_completable_future.i_waiting_first;

import java.util.concurrent.CompletableFuture;

/**
 * Suppose, we have two temperature services which provides the temperature value
 * we want to call both, but whichever service responds first, we will take that value
 */
public class WaitingForOneTaskApplication {
    public static void main(String[] args) {
        var slowService = CompletableFuture.supplyAsync(() -> {
           LongRunningTask.simulateLongRunningTask();
           return 20;
        });
        var fastService = CompletableFuture.supplyAsync(() -> 30);

        CompletableFuture
                .anyOf(slowService, fastService)
                .thenAccept(System.out::println);
    }
}
