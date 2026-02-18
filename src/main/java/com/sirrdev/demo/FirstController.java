package com.sirrdev.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    //Creating an endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello brother sirrrdev! from my first controller";
    }

    @PostMapping("/post")
    public String post (
            @RequestBody String message
    ) {
        return "Request accepted and message  is : " + message;
    }
}
