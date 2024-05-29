package com.example.toygry.controller;

import com.example.toygry.entity.Recommend;
import com.example.toygry.service.TestService;
import com.example.toygry.utils.KeycloakToken;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World this is api server 1: ";
    }

    @GetMapping("/token")
    public KeycloakToken getToken(@RequestHeader("Authorization") String token) {
        return testService.getToken(token);
    }

    @GetMapping("/test")
    public String test() {
        Recommend recommend = Recommend.builder()
                .build();

        Recommend.Builder builder = new Recommend.Builder();
        Recommend recommend1 = builder.id(1).content(false).build();


        return recommend.toString();
    }
}
