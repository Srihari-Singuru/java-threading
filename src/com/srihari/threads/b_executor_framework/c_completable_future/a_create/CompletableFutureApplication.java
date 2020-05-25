package com.srihari.threads.b_executor_framework.c_completable_future.a_create;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureApplication {
    public static void main(String[] args) {
        Supplier<Double> supplier = Math::random;
        CompletableFuture<Double> result = CompletableFuture.supplyAsync(supplier);    // it takes Executor argument as well
                                                                                        // if we do not pass, then default pool will be taken
                                                                                        // default - ForkJoinPool.commonPool(); - number of available threads in runtime

        /* Runnable task = () -> System.out.println("Srihari");
        CompletableFuture<Void> result = CompletableFuture.runAsync(task); */   // We can pass Runnable also

        // For time being we will use blocking call to fetch the result
        try {
            var output = result.get();
            System.out.println(output);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
