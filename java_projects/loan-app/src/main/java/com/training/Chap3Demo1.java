package com.training;

public class Chap3Demo1 {

    public static void main(String[] args) {
        String name1 = "neha";
        name1 = "riya";
        String name2 = "neha";
        String name3 = new String("neha");
        String name4 = "neha";

        System.out.println(name1==name3);		//false
        System.out.println(name2==name3);		//false
        System.out.println(name2==name4);		//true
        System.out.println(name3==name4);		//false

        char[] text = {'H','e','l','l','o'};
        String a = new String(text);
        String b = new String("Hello");
        String c = a.intern();
       String d = b.intern();

        System.out.println(a==b);       //false
        System.out.println(a==c);          //false
        System.out.println(c==a);       //false

        System.out.println("c==d : " +(c==d));       //true

        String e = a.intern();      //new memory
        System.out.println("c==e : " +(c==e));       //true
        c= "JJ";
        System.out.println("After change : c==d : " +(c==d));       //false

    }
}
