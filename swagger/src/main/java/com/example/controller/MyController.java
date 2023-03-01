package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {

    @PostMapping("/hello")
    public String PostHello(){
        return "hello";
    }

    @GetMapping("/hello")
    public String GetHello(String name, String age) {
        return "hello";
    }
    @RequestMapping("/hello")
    public String ReqHello(){
        return "hello";
    }
}
