package com.srihari.threads.a_multi_threading.f_thread_safety.b_solution_strategy.c_sync_alternate_volatile.b_volatile_with_signalling;

/**
 * DO NOT use wait notify in new code, as we have better mechanisms
 */
public class WaitNotifyApplication {
    public static void main(String[] args) {
        var status = new DownloadStatus();

        Thread thread1 = new Thread(new DownloadFileTask(status));
        Thread thread2 = new Thread(() -> {
            // It wastes CPU cycles (so many iterations) - so, we need to use wait and notify methods
            /* while(!status.isDone()) {} */

            // here, while loop doesn't run in loop since we are calling 'wait' method
            while(!status.isDone()) {
                synchronized (status) {     // Java expects us to invoke the wait method inside the synchronized block
                    try {
                        status.wait();      // Object class method 'wait' to ask thread to go onto wait state, util it is notified
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}
