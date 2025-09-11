package com.training.softbankrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sayHello")
public class GreetingController {

    @GetMapping
    public String getMessage(){
        return "Hello Darshan, How are you today";
    }
}
