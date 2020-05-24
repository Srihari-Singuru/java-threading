package com.srihari.threads.multithreading.interrupt;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading the file. Thread Name: "+Thread.currentThread().getName());

        // planning to print a message for very long time to simulate the interrupt feature
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(Thread.currentThread().isInterrupted()){ // checks whether interrupt signal is sent or not
                return;
            }
            System.out.println("Downloading the byte: "+i);
        }

        System.out.println("Downloading completed. Thread Name: "+Thread.currentThread().getName());
    }
}
