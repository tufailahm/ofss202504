package threaddemos;

import java.util.Scanner;

//i need to ask user to enter the name and when he answer within 20 seconds then welcome
//else better luch next time
public class HandsonThread extends Thread {
public static void main(String[] args) {
    String[]name=new String[1];

    Scanner sc=new Scanner(System.in);
    Thread t1=new Thread(()->{
    System.out.println("Enter name:-");
            name[0]=sc.nextLine();
    });

    t1.start();
    try {
        t1.sleep(10_000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    if(name[0]!=null){
        System.out.println("Hello "+name[0]);
    }
    else{
        System.out.println("Better luck next time");

    }
    System.out.println("Thread ended");
    System.exit(0);
}

}
