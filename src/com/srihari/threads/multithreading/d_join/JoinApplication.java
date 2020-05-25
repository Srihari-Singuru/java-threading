package com.srihari.threads.multithreading.d_join;

/**
 * Assume we would like to scan the downloaded file
 * We do not know when the download thread will be completed
 * so, to wait for download thread to be completed, we use 'join'
 */
public class JoinApplication {
    public static void main(String[] args) {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start(); // Download thread started

        try {
            thread.join();  // wait for Download thread to be completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File downloaded and is ready to be scanned");
    }
}
