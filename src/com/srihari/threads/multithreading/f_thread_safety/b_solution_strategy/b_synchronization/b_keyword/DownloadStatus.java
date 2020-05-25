package com.srihari.threads.multithreading.f_thread_safety.b_solution_strategy.b_synchronization.b_keyword;

/**
 * DO NOT use Synchronization in new code - This example is just for knowledge
 * and, may be old code base may have this synchronized keywords, hence learning this
 */
public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;

    // use synchronized keyword instead of lock object
    public void incrementTotalBytes(){
        synchronized (this){    // using 'this' is a bad practise
                                // here inside the braces parameter is called 'Monitor' object
            totalBytes++;
        }
    }

    public void incrementTotalFiles(){
        synchronized (this){    // if we use 'this' in the above method, then
                                // this method will not get execute if some thread is using the above method simultaneously
                                // it reduces the throughput of the class by having unnecessary waits
                                // we can have synchronized keyword in the method (public synchronized void incrementTotalFiles())
                                // but that is as same as 'synchronized(this)'
            totalFiles++;
        }
    }

    /*
    Instead of using 'this' as the monitor object,
    we can create two new fields
        Object totalBytesLock = new Object();
        Object totalFilesLock = new Object();

     and can use these in corresponding synchronized blocks
        synchronized(totalBytesLock) {}
        synchronized(totalFilesLock) {}
     */

    public int getTotalBytes() {
        return totalBytes;
    }

    public int getTotalFiles() {
        return totalFiles;
    }
}
