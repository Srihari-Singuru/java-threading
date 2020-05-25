package com.srihari.threads.b_executor_framework.c_completable_future.g_combining;

import java.util.concurrent.CompletableFuture;

/**
 * ability to start two tasks asynchronously and then combine the results
 */
public class CombiningApplication {
    public static void main(String[] args) {
        /**
         * get the amount in dollars
         * get the dollar to rupee conversion rate
         * the above two tasks should be parallel
         *
         * then combine the result
         */
        var first = CompletableFuture.supplyAsync(() -> 20);    // 20 USD
                                                                // if we want we can add thenApply etc for any mapping or anything else to be done
        var second = CompletableFuture.supplyAsync(() -> 76);   // 76 INR - exchange rate

        // 'first' and 'second' tasks start parelally
        first       // first task
            .thenCombine(
                    second,     // second task
                    (dollar, exchangeRate) -> dollar * exchangeRate     // BiFunction to combine the results
            )
            .thenAccept(System.out::println);
    }
}
