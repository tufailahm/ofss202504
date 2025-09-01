package com.training;


import com.training.com.training.model.Product;
import com.training.util.*;

import java.math.BigDecimal;
import java.util.Date;


public class App
{
    public static void main( String[] args )
    {
        System.out.println("Main app started");
//        Employee e = new Employee();
//        e.addEmployee();
//     //   com.training.util.RandomMessage r = new  com.training.util.RandomMessage();
//     //   System.out.println(r.generateRandomMessage());
//        RandomMessage dm = new RandomMessage();
//        System.out.println(dm.generateRandomMessage());
//        Date d = new Date();
//        System.out.println(d);

        Product product = new Product();
       // product.setId(100);
        product.setName("Mouse");
        product.setPrice(BigDecimal.valueOf(2000));

    //    System.out.println(product.calculateBill(BigDecimal.valueOf(15)));
        product.applyDiscount(BigDecimal.valueOf(15));
        product.addPrice(); //add 100
        product.displayProduct();

        Product product2 = new Product();
      //  product2.setId(100);
        product2.setName("Mouse");
        product2.setPrice(BigDecimal.valueOf(2000));

        //    System.out.println(product.calculateBill(BigDecimal.valueOf(15)));
        product2.applyDiscount(BigDecimal.valueOf(15));
        product2.addPrice(); //add 100


        product.storeName = "Demo";
        Product.storeName = "Hello";
        product2.displayProduct();



        Product product3 = new Product();
        product3.setPrice(12.98);

        product3.applyDiscount(12,18,24,90);
        product3.applyDiscount(12);


        Product product4 = new Product(98,909);

     //   product4.setId(11212);
        product4.displayProduct();
    }
}
