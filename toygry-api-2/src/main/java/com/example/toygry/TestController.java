package com.example.toygry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World this is api server 2";
    }
}
