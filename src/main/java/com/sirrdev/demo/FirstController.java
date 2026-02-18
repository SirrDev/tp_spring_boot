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
    public String post(
            //to map the body of the request with the method parameter
            @RequestBody String message
    ) {
        return "Request accespted and message is : " + message;
    }

    @PostMapping("/post-order")
    public String post(
            //to map the body of the request with the method parameter
            @RequestBody Order order
    ) {
        return "Request accespted and order is : " + order.toString();
    }
}
