package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithmeticController {
    @Autowired
    Arithmetic arithmetic;

        @GetMapping("/greeting/arithmetic")
        public Arithmetic arithmeticController() {
            return arithmetic;
        }
}
