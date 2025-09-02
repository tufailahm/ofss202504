package collectiondemos.demo;

import com.training.util.Demo;

public class DemoException2 {

    public static void display1() throws InterruptedException {
        System.out.println("Hello World1");
        Thread.sleep(2000);
        System.out.println("Hello World2");
    }
    public static void display2() throws InterruptedException {
        System.out.println("Hello World1");
        Thread.sleep(2000);
        System.out.println("Hello World2");
    }
    public static void main(String[] args) {

        System.out.println("Main called");
        try {
            DemoException2.display1();
            DemoException2.display2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main called ended");
    }
}
