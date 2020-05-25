package com.srihari.threads.multithreading.f_thread_safety.a_race_condition;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    // All the threads will try to increment the totalBytes size at the same time
    public void incrementTotalBytes(){
        totalBytes++;   // we call this not-atomic operation
        // the above statement involves three steps
        // 1. Store the totalBytes into memory
        // 2. Increment by 1
        // 3. Again store the incremented value in the memory
    }
}
