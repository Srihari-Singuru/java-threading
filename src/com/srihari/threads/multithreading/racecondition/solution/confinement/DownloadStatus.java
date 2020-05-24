package com.srihari.threads.multithreading.racecondition.solution.confinement;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes(){
        totalBytes++;
    }
}
