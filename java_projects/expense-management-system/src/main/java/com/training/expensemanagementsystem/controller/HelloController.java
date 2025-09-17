package com.training.expensemanagementsystem.controller;

import com.training.expensemanagementsystem.util.Data;
import com.training.expensemanagementsystem.util.Person;
import com.training.expensemanagementsystem.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    RandomGenerator getRandomGenerator2;

    @GetMapping("randomWeather")      // localhost:9090/random
    public String random() {
        return "Weather Temperature is :"+String.valueOf(getRandomGenerator2.getRandomNumber(100,200));
    }

    @Autowired
    Person person ;

    @GetMapping("welcome")
    public String welcome() {
            return "Welcome :"+person.getFirstName();
    }

    @Autowired(required=false)
    Data data;

    @GetMapping("data")         //localhost:9090/data
    public String getData() {
        return "Welcome :"+data.getData();
    }

}
