package com.srihari.threads.multithreading.racecondition.solution.confinement;

public class DownloadFileTask implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.println("Downloading the file. Thread Name: "+Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if(Thread.currentThread().isInterrupted()){ // checks whether interrupt signal is sent or not
                return;
            }

            // Now, 'status' is no more a shared location
            status.incrementTotalBytes();
        }

        System.out.println("Downloading completed. Thread Name: "+Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
