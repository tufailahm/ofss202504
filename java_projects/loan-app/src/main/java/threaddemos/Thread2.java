package threaddemos;

public class Thread2 extends Thread {

    public static void main(String[] args) {

        Thread2 parentthread = new Thread2(){
            public void run(){
                System.out.println("Parent Name");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Parent Name");
                System.out.println("Parent Name");
            }
        };
        Thread childthread = new Thread2(){
            public void run(){
                try {
                    parentthread.interrupt();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Child's Name");
                System.out.println("Child's Name");
            }
        };

        parentthread.start();
        childthread.start();

    }
}