package com.training.util;

class Object{
    static {
        System.out.println("Object Static");
    }
    public Object(){
        System.out.println("Object Constructor");
    }
}

public class Shop extends Object{
    static {
        System.out.println("Shop Static");
    }

    public static void main(String[] args) {
        Product1 p1 = new Food();
        Product1 p2 = new Food();
    }
}

class Product1{
    static {
        System.out.println("Product Static");
    }
    public Product1(){
        System.out.println("Product Constructor");
    }
}

class Food  extends Product1{
    static  {
        System.out.println("Food Static");
    }
    public Food(){
        System.out.println("Food Constructor");
    }
}


