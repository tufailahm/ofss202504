package threaddemos;

public class Demo2 implements Runnable{

    Thread t1;

    public Demo2(){
        t1 = new Thread(this);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }

    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("Parent Name" );}
    }

    public static void main(String[] args){

        new Demo2();
        for (int i=0;i<3;i++){
        System.out.println("My name");}


    }
}
