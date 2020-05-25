package com.srihari.threads.multithreading.racecondition.solution.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private AtomicInteger totalBytes = new AtomicInteger();

    public int getTotalBytes() {
        return totalBytes.get();
    }

    // unlike totalBytes++, atomic will not use three steps
    public void incrementTotalBytes(){
        totalBytes.incrementAndGet();   // it uses technique called compare and swap (single step)
    }
}
