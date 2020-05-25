package com.srihari.threads.b_executor_framework.c_completable_future.d_exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionApplication {
    public static void main(String[] args) {
        var future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Getting the current temperature");
                    throw new IllegalStateException();      // assume the thread has thrown an exception
                    //return 10;
                });

        try {
            var result = future
                            .exceptionally(ex -> {      // returns default value '5' when exception occurs, and returns new CompletableFuture
                                System.out.println(ex.getMessage());
                                return 5;
                            })
                            .get();     // if exception occurs, then get() will be on new CompletableFuture generated
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
