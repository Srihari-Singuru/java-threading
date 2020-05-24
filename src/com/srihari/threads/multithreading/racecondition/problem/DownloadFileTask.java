package com.srihari.threads.multithreading.racecondition.problem;

public class DownloadFileTask implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading the file. Thread Name: "+Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if(Thread.currentThread().isInterrupted()){ // checks whether interrupt signal is sent or not
                return;
            }

            // thread is trying to increment the 'totalBytes' which is at shared location by all threads
            status.incrementTotalBytes();
        }

        System.out.println("Downloading completed. Thread Name: "+Thread.currentThread().getName());
    }
}
