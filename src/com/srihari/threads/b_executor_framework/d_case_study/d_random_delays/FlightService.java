package com.srihari.threads.b_executor_framework.d_case_study.d_random_delays;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public Stream<CompletableFuture<Quote>> getQuotes(){
        var sites = List.of("site1", "site2", "site3");

        return sites.stream()
                    .map(this::getQuote);   // site -> getQuote(site)
    }

    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("Getting a quote from "+site);
                        var random = new Random();
                        LongRunningTask.simulateLongRunningTask(1_000 + random.nextInt(2000)); // sample deplay between quotes fetching
                        return new Quote(site, 100 + random.nextInt(10));
                    });
    }
}
