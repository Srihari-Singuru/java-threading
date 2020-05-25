package com.srihari.threads.b_executor_framework.b_callable_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureApplication {
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(4);

        try {
            // passing callable (not runnable) which will give some response
            Future<Integer> future = executor.submit(() -> {    // result in a future object
                                        LongRunningTask.simulateLongRunningTask();  // sleeps for 5 sec
                                        return 1;
                                    });

            // Do something else here

            // when we need the value of the future
            try {
                var result = future.get();  // blocking call
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        finally {
            executor.shutdown();
        }
    }
}
