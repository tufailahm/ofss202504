package com.training;

public class Calculator {

    public int addNumbers(int num1,int num2){
        return num1+num2;
    }

    public int convertStringToInt(String s){        //"90"  //"Ninety"
        return Integer.parseInt(s);
    }

    public int divideNumbers(int num1,int num2){
        return num1/num2;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Calculator object reclaimed");    }
}
