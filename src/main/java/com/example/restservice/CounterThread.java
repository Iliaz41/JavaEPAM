package com.example.restservice;

import org.springframework.stereotype.Component;

@Component
public class CounterThread extends Thread {

    private boolean check = true;

    public CounterThread() {
        super();
        start();
    }

    public void run() {
        if (Thread.currentThread().getName().equals("Thread-1")) check = false;
        while (check) {
            try {
                Synchronization.semaphore.acquire();
                Counter.INSTANCE.increment();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
