package com.srihari.threads.multithreading.a_general;

public class GeneralApplication {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());   // currently active threads
        System.out.println(Runtime.getRuntime().availableProcessors()); // total available threads in the hardware
    }
}
