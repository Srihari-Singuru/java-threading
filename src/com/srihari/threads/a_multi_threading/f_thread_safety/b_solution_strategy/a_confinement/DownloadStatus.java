package com.srihari.threads.a_multi_threading.f_thread_safety.b_solution_strategy.a_confinement;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes(){
        totalBytes++;
    }
}
