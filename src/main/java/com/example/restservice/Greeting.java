package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
    @JsonProperty("String:")
    private final String string;
    @JsonProperty("Symbol for search:")
    private final String symbol;
    @JsonProperty("Result:")
    private int counter;

    Greeting(String string, String symbol) {
        this.string = string;
        this.symbol = symbol;
        this.counter = Counter();
    }

    public int Counter() {
        char[] str = string.toCharArray();
        char[] sym = symbol.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            int j = 0;
            if (str[i] == sym[j]) counter++;
        }
        return counter;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getString() {
        return string;
    }

    public int getCounter() {

        return this.counter;
    }

    public int getLength() {

        return this.string.length();
    }
}
