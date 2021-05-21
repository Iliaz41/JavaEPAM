package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
public class Synchronization {
    final static Semaphore semaphore = new Semaphore(1, true);
}
