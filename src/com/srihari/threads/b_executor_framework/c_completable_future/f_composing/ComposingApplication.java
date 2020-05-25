package com.srihari.threads.b_executor_framework.c_completable_future.f_composing;

import java.util.concurrent.CompletableFuture;

/**
 * Assuming we have id if a user
 * by using id, we wat to get email of a user asynchronously
 * after completing the above thread, by using email we want to get the songs playlist of a user
 * then print the playlist
 */
public class ComposingApplication {
    public static void main(String[] args) {
        getUserEmailAsync()
                .thenCompose(ComposingApplication::getUserPlaylistAsync)    // pass a Function, which returns CompletionStage
                .thenAccept(System.out::println);

        // add timer if main thread terminates early
    }

    private static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    private static CompletableFuture<String> getUserPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }
}
