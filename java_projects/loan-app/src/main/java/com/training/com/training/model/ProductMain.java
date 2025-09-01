package com.training.com.training.model;

import java.math.BigDecimal;
import java.util.Arrays;

public class ProductMain {

    public static void main(String[] args) {
        Product p1 = new Product(1,"Mouse", BigDecimal.valueOf(111));
        Product p2 = new Product(1,"Mouse", BigDecimal.valueOf(111));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1==p2);                 //false
        System.out.println(p1.equals(p2));          //TRUE

        //hashcode
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        String str1 = "Neha1";
        String str2 = new String("Rohit4");
        System.out.println(str1==str2);         //false
        System.out.println(str1.equals(str2));      //true
        System.out.println(str1.hashCode());        //121
        System.out.println(str2.hashCode());        //122

        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");
        String d = "heLLo";
        boolean sameObjectAB = (a == b);                 //true
        boolean sameObjectAC = (a == c);                 //false
        boolean sameContentAB = (a.equals(b));           //true
        boolean sameContentCA = (a.equals(c));           //true
        boolean sameContentAD = (a.equals(d));           //false
        boolean sameNoCaseAD = (a.equalsIgnoreCase(d));  //true

        Customer c1 = new Customer(1,"Rohit",10);
        Customer c2 = new Customer(1,"Rohit",10);

        System.out.println(c1.equals(c2));
        System.out.println(c1.bill());

        Product [] products = new Product[5];
        for(int i=0;i<5;i++){
            products[i] = new Product(i+1,"Mouse",BigDecimal.valueOf(111));
        }
        products[3].displayProduct();

        String[] names1 = {"Mary","Ann","John","Tom"};
        String[] names2 = {"Mary","Ann","John","Tom"};
        boolean isTheSame = Arrays.equals(names1, names2);
        Arrays.sort(names2);
        for(int i=0;i<names2.length;i++){
            System.out.println(names2[i]);
        }
        System.out.println(isTheSame);
    }
}
