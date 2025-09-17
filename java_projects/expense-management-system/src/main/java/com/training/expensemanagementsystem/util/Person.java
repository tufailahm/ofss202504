package com.training.expensemanagementsystem.util;

import org.springframework.stereotype.Component;


@Component
//Person person = new Person
public class Person {

    String firstName;

    public Person(){
        this.firstName="Rohit";
        System.out.println("Person def cons called");
    }
    public Person(String firstName) {
        this.firstName = firstName;
        System.out.println("Person  cons 2 called");
    }
    public String getFirstName() {
        return firstName;
    }
}
