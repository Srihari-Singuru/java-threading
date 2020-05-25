package com.srihari.threads.b_executor_framework.d_case_study.b_getting_quote;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FlightService {
    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("Getting a quote from "+site);
                        return new Quote(site, 100 + new Random().nextInt());
                    });
    }
}
