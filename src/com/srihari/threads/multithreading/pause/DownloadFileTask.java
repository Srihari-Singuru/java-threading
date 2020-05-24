package com.srihari.threads.multithreading.pause;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading the file. Thread Name: "+Thread.currentThread().getName());

        try {
            Thread.sleep(5000); // Pauses for aprrox 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Downloading completed. Thread Name: "+Thread.currentThread().getName());
    }
}
