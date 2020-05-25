package com.srihari.threads.multithreading.racecondition.solution.synchronizationalternate.signalling;

/**
 * volatile soles the 'visibility problem'
 */
public class DownloadStatus {
    // if we do not use volatile, then changes made to 'done' field by thread1 is not visible to thread2
    private volatile boolean done;  // always read it from the main memory (not from cache)

    private int totalBytes;
    private final Object totalBytesLock = new Object();

    public void incrementTotalBytes(){
        synchronized (totalBytesLock){
            totalBytes++;
        }
    }

    public void done() {
        this.done = true;
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public boolean isDone() {
        return done;
    }
}
