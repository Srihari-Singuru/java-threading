package com.srihari.threads.a_multi_threading.e_interrupt;

public class InterruptApplication {
    public static void main(String[] args) {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start(); // thread started

        try {
            Thread.sleep(1000); // Pause the main thread for 1 sec (so that after 1 sec, we can interrupt the 'Thread-0' thread)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 'thread' may not be interrupted. It is just a interrupt request sent to thread.
        // We need to check for thread interruption in corresponding thread itself after sending the interrupt request
        // If a thread is sleeping, and if we request for interruption, then it throws an exception, hence we need to handle 'InterruptedException' at the time of 'Thread.sleep'
        thread.interrupt();
    }
}
