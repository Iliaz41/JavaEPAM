package com.example.restservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public enum Counter {
    INSTANCE;
    private int counter = -1;
    private static final Logger logger = LogManager.getLogger(GreetingController.class);

    public void increment() {
        this.counter++;
        logger.info("Counter: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}

