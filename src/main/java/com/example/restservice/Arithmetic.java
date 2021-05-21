package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Arithmetic {
    @JsonProperty("Min length of string")
    private int minLength;
    @JsonProperty("Max length of string")
    private int maxLength;
    @JsonProperty("Max result")
    private int max;
    @JsonProperty("Min result")
    private int min;
    @JsonProperty("Average")
    private double avr;

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setAvr(double avr) {
        this.avr = avr;
    }
}
