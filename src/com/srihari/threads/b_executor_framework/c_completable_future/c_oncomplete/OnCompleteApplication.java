package com.srihari.threads.b_executor_framework.c_completable_future.c_oncomplete;

import java.util.concurrent.CompletableFuture;

public class OnCompleteApplication {
    public static void main(String[] args) {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(Math::random);

        /*
         * We have many such methods like thenRun, thenRunAsync etc etc.
         */

        // thenAccept expects Consumer
        future.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        // thenAcceptAsync expects Consumer - Asynchronous way
        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        // keep timer here, if program terminates before the threads execution
    }
}
