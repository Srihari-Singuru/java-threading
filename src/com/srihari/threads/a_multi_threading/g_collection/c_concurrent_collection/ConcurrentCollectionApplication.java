package com.srihari.threads.a_multi_threading.g_collection.c_concurrent_collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionApplication {
    public static void main(String[] args) {
        // It uses a partitioning technique, doesn't use synchronization
        // and different threads can access different methods a the same time (unlike SynchronzedCollection)
        Map<Integer, String> map = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(() -> {
            map.putAll(Map.of(1, "a"));
        });
        Thread thread2 = new Thread(() -> {
            map.putAll(Map.of(2, "b"));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // All the values may not be printed, due to race condition
        System.out.println(map);
    }
}
