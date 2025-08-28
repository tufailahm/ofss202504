package com.training;


import com.training.util.*;

import java.util.Date;


public class App
{
    public static void main( String[] args )
    {
        System.out.println("Main app started");
        Employee e = new Employee();
        e.addEmployee();
     //   com.training.util.RandomMessage r = new  com.training.util.RandomMessage();
     //   System.out.println(r.generateRandomMessage());
        RandomMessage dm = new RandomMessage();
        System.out.println(dm.generateRandomMessage());
        Date d = new Date();
        System.out.println(d);
    }
}
