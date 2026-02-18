package com.sirrdev.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    //Creating an endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello brother sirrrdev! from my first controller";
    }
    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello 2  brother sirrrdev! from my first controller";
    }
}
