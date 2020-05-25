package com.srihari.threads.b_executor_framework.d_case_study.b_getting_quote;

public class BestPriceApplication {
    public static void main(String[] args) {
        var flightService = new FlightService();

        flightService
            .getQuote("site1")
            .thenAccept(System.out::println);

        // pausing for 10 sec to complete the program
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
