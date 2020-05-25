package com.srihari.threads.a_multi_threading.c_pause;

public class PauseApplication {
    public static void main(String[] args) {
        System.out.println("Before initiating. Thread Name: "+Thread.currentThread().getName());

        // 1o threads will be completed in 5 sec, instead of 50 sec (in case of sequential)
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();     // new Thread will be initiated
        }
    }
}
