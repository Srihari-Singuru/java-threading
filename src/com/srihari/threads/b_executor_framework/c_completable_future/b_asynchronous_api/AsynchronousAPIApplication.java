package com.srihari.threads.b_executor_framework.c_completable_future.b_asynchronous_api;

public class AsynchronousAPIApplication {
    public static void main(String[] args) {
        var mailService = new MailService();

        //mailService.send();    // synchronous way
        mailService.sendAsync();    // asynchronous way

        System.out.println("Main method executed");

        // explicit wait is needed, otherwise 'main' thread will complete before the 'sendAsync()' completes
        // But in realtime, this is not required as the application will run until we restart jvm
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
