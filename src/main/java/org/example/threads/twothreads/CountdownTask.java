package org.example.threads.twothreads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class CountdownTask implements Runnable {
    private final AtomicInteger number;
    private final AtomicBoolean found;

    CountdownTask(AtomicInteger number, AtomicBoolean found) {
        this.number = number;
        this.found = found;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().setName("Thread-Number");
            while(!found.get()){
                Thread.sleep(600);
                System.out.println(number.getAndDecrement());
            }
            System.out.println("Thread name: " + Thread.currentThread().getName());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
