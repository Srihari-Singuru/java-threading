package com.srihari.threads.multithreading.create;

public class CreateThreadApplication {
    public static void main(String[] args) {
        System.out.println("Before initiating. Thread Name: "+Thread.currentThread().getName());

        Thread thread = new Thread(new DownloadFileTask());
        thread.start();     // new Thread will be initiated

        // 10 new Threads will be initiated
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new DownloadFileTask());
            thread1.start();     // new Thread will be initiated
        }
    }
}
