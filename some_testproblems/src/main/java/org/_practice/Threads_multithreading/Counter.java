package org._practice.Threads_multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
     AtomicInteger count = new AtomicInteger();

    public  void increments() {

        for (int i = 0; i < 1000; i++) {
            count.getAndIncrement();
        }
    }
}