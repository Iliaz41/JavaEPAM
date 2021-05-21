package com.example.restservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GreetingTest {
    @Test
    void TestingTrue() {
        Greeting test = new Greeting("qqqqqwwwwwrrrrf", "w");
        int result1 = 5;
        int result2 = test.Counter();
        Assertions.assertEquals(result1, result2);
    }

    @Test
    void TestingFalse() {
        Greeting test = new Greeting("ffggggghhhhhhhhh", "h");
        int result1 = 3;
        int result2 = test.Counter();
        Assertions.assertNotEquals(result1, result2);
    }

    @Test
    public void whenExceptionThrown_thenExpectationSatisfied() {
        String test = null;
        test.length();
    }
}