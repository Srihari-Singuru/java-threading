package com.srihari.threads.a_multi_threading.g_collection.a_race_condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class RaceCollectionApplication {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });
        Thread thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
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
        System.out.println(collection);
    }
}
