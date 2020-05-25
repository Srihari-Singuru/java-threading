package com.srihari.threads.b_executor_framework.d_case_study.c_getting_many_quotes;

import java.util.stream.Collectors;

public class BestPriceApplication {
    public static void main(String[] args) {
        var flightService = new FlightService();

        flightService
            .getQuotes()
            .map(future -> future.thenAccept(System.out::println))
            .collect(Collectors.toList());

        // pausing for 10 sec to complete the program
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
