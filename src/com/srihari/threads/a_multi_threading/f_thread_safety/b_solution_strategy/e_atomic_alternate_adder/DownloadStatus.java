package com.srihari.threads.a_multi_threading.f_thread_safety.b_solution_strategy.e_atomic_alternate_adder;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {

    // Adder classes provide more throughput than Atomic classes
    // we can use this if we have very frequent updates
    // it internally uses counter of arrays, hence no multiple steps involved
    private LongAdder totalBytes = new LongAdder(); // internally calls 'sum' method to count the counters

    public int getTotalBytes() {
        return totalBytes.intValue();
    }

    public void incrementTotalBytes(){
        totalBytes.increment();
    }
}
