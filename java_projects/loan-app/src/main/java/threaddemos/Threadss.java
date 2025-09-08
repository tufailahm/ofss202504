package threaddemos;

import java.util.Scanner;

public class Threadss extends Thread {
    public static void main(String[] args) {
        String name;
        Scanner sc = new Scanner(System.in);
        final Thread[] t1 = new Thread[1];

        Thread t2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("Better Luck next time");
                    t1[0] = null;
                } catch (InterruptedException e) {

                }
            }
        };
         t1[0] = new Thread() {
            public void run() {
                t2.start();
                System.out.println("Enter your name : ");
                String name = sc.next();
                if (name != null ){
                    t2.interrupt();
                    System.out.println("Welcome " + name);
                }
                else {

                }
            }
        };
        t1[0].start();
    }
}