package com.cicdautomation.pipeline;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        // return "Hello CI/CD v1";
        return "Hello CI/CD v2.9";
    }
}