package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/greeting/request")
    public String requestController() {
        return ("Counter: " + Counter.INSTANCE.getCounter());
    }
}
