package com.srihari.threads.b_executor_framework.c_completable_future.b_asynchronous_api;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send() {
        LongRunningTask.simulateLongRunningTask();
        System.out.println("Main was sent");
    }

    // Asynchronously calling the above method
    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(this::send);  // () -> send();
    }
}
