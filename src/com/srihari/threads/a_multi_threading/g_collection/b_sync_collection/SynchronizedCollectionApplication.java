package com.srihari.threads.a_multi_threading.g_collection.b_sync_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SynchronizedCollectionApplication {
    public static void main(String[] args) {
        // with synchronized collection, all the methods inside the Arraylist are synchronized
        // The entire collection gets locked :(
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

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
