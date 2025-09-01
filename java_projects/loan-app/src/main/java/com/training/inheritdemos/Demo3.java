package com.training.inheritdemos;

import com.training.util.Z;

interface X1  {
   void a();
    public default void c() {}
}


abstract class W {
     void a() {
        System.out.println("W a called");
    }
}
class ZZ extends W implements X1 {
    @Override
   public void a(){
       System.out.println("ZZ a called");
   }
}

public class Demo3 {
    public static void main(String[] args) {
        ZZ z = new ZZ();

    }
}
