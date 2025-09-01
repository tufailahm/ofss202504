package com.training.util;

class W {
    public W() {
        System.out.println("4. W 1 constructor");
    }
    public W(String name) {
        System.out.println("4. W 2 constructor");
    }
    static {
        System.out.println("#1. W static block");
    }
}
public class Z extends W {
    {
        System.out.println("5. instance block");
    }
    static {
        System.out.println("#2. Z static block");
    }
    public Z(String name) {
        super(name);
        System.out.println("6. Z constructor");
    }
    public static void main(String args[]) {
        System.out.println("#3. In main");
        new Z("YY");
    }
}