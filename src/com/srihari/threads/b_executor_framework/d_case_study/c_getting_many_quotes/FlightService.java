package com.srihari.threads.b_executor_framework.d_case_study.c_getting_many_quotes;

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
                        return new Quote(site, 100 + new Random().nextInt());
                    });
    }
}
