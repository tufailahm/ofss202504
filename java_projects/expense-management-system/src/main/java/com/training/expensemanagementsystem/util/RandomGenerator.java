package com.training.expensemanagementsystem.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RandomGenerator {

    private int max;
    private int min;

    public RandomGenerator(int max, int min) {
        System.out.println("Random Generator object created with min and max: " + min + " and max: " + max);
        this.max = max;
        this.min = min;
    }

    public RandomGenerator()
    {
        System.out.println("Random Generator object created ");
    }
    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
