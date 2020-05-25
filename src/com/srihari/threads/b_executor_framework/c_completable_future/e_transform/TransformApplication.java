package com.srihari.threads.b_executor_framework.c_completable_future.e_transform;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TransformApplication {
    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 20);   // assume returning 20 degree celsius

        // using try catch etc etc
        try {
            var result = future
                            .thenApply(celsius -> (celsius * 1.8) + 32) // 'thenApply()' is like map in Streams
                            .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Declarative way of writing code
        future
            .thenApply(TransformApplication::toFahrenheit)  // mapping
            .thenAccept(System.out::println);       // consumer - to print
    }

    private static double toFahrenheit(int celsius) {
        return (celsius * 1.8) + 32;
    }
}
