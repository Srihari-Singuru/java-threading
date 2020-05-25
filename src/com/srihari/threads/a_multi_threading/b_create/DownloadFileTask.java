package com.srihari.threads.a_multi_threading.b_create;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading the file. Thread Name: "+Thread.currentThread().getName());
    }
}
