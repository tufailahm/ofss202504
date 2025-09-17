package com.training.expensemanagementsystem.config;

import com.training.expensemanagementsystem.util.Person;
import com.training.expensemanagementsystem.util.RandomGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfssConfig {

    @Bean
    public RandomGenerator getRandomGenerator1()
    {
        return new RandomGenerator();
    }
    @Bean
    public RandomGenerator getRandomGenerator2()
    {
        return new RandomGenerator(900,1500);
    }
    @Bean
    public Person person1(){
        return new Person("Aryan");
    }
}
