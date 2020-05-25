package com.srihari.threads.b_executor_framework.d_case_study.d_random_delays;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class BestPriceApplication {
    public static void main(String[] args) {
        var start = LocalTime.now();
        var flightService = new FlightService();

        // wait for all of the threads to complete
        CompletableFuture
                .allOf(flightService
                            .getQuotes()
                            .map(future -> future.thenAccept(System.out::println))
                            .toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                        var end = LocalTime.now();
                        var duration = Duration.between(start, end);
                        System.out.println("Retrieved all quotes in "+duration.toMillis()+" msec");
                });

        /*var futures = flightService
                .getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        // wait for all of the threads to complete
        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in "+duration.toMillis()+" msec");
                });*/

        // add sleep timer if main thread terminates early
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
