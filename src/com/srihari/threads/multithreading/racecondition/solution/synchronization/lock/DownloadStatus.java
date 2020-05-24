package com.srihari.threads.multithreading.racecondition.solution.synchronization.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private final Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    // Using Lock object to handle the race condition
    public void incrementTotalBytes(){
        lock.lock();
        try {
            totalBytes++;
        }
        finally {
            lock.unlock();
        }
    }
}
