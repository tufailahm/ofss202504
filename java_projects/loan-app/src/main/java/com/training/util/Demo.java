package com.training.util;

public class Demo {

    public Demo(){
        System.out.println("4. constructor demo called");
    }
    {
        System.out.println("3. Demo initializer called");
    }
    static
    {
        System.out.println("1. DEMO static initalizer called");
    }
    public static void main(String[] args) {
        System.out.println("2. MAIN CALLED");
        Demo d = new Demo();
    }
}
