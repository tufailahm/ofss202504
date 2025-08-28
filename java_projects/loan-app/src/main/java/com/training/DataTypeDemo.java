package com.training;

import javax.xml.crypto.Data;

public class DataTypeDemo {

int num1=100;
int num2=200;
int num3=300;
boolean result;

public void display() {
    result = num1>num2 &  num3++ > 200;

    System.out.println(result);
    System.out.println(num3);
}
    public static void main(String[] args) {
        char status = 'D';
        double price = 10;
        switch (status) {
            case 'S', 'N' -> price += 1;
            case 'D' -> {
                double discount = price*0.2;
                price -= discount;

            }
            case 'E' -> price = 0;
            default -> price = 3;
        }

        char status2 = 'D';
        double cost2 = 10;
        double price2 = switch (status) {
            case 'S', 'N' -> cost2 += 1;
            case 'D' -> {
                double discount = cost2*0.2;
                cost2 -= discount;
              yield     cost2;
            }
            case 'E' -> 0;
            default -> 3;
        };



        System.out.println("Price is " + price2);
    }
}