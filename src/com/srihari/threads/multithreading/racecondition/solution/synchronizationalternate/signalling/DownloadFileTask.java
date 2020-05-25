package com.srihari.threads.multithreading.racecondition.solution.synchronizationalternate.signalling;

public class DownloadFileTask implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading the file. Thread Name: "+Thread.currentThread().getName());

        for (int i = 0; i < 10_00_000; i++) {
            if(Thread.currentThread().isInterrupted()){ // checks whether interrupt signal is sent or not
                return;
            }

            // thread is trying to increment the 'totalBytes' which is at shared location by all threads
            status.incrementTotalBytes();
        }
        // set the status to done
        status.done();

        synchronized (status) { // like 'wait', jvm expects us to keep 'notify' inside synchronized block
            status.notifyAll();    // need to inform other thread (that used status.wait())
            //status.notify(); // if only one thread is waiting for this 'status' object
        }

        System.out.println("Downloading completed. Thread Name: "+Thread.currentThread().getName());
    }
}
