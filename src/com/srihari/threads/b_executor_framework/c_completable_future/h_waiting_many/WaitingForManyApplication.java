package com.srihari.threads.b_executor_framework.c_completable_future.h_waiting_many;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WaitingForManyApplication {
    public static void main(String[] args) {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

        CompletableFuture                   // returns Void as every task may result in separate data types
            .allOf(first, second, third)    // waits for all three tasks to be completed - asynchronously
            .thenRun(() -> {        // takes runnable

                // if we specifically want to get the each value
                try {
                    var firstResult = first.get();      // Non-blocking, as the result is already available by the time we call 'thenRun()'
                    var secondResult = second.get();
                    var thirdResult = third.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

                System.out.println("All tasks executed successfully");
            });
    }
}
