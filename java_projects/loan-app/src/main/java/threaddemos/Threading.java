package threaddemos;

public class Threading extends Thread {

    @Override
    public void run() {
        System.out.println("1. Parent's Name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Parent sleep interrupted");
        }
        System.out.println("2. Parent's Name");
        System.out.println("3. Parent's Name");
    }

    public static void main(String[] args) {
        Threading parentThread = new Threading();
        parentThread.setName("Parent Thread");

        Thread childThread = new Thread() {
            @Override
            public void run() {
                System.out.println("1. Child's Name: " + Thread.currentThread().getName());
                try {
                    parentThread.interrupt();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("2. Child's Name: " + Thread.currentThread().getName());
                System.out.println("3. Child's Name");
            }
        };
        childThread.setName("Child Thread");
        childThread.setPriority(Thread.MAX_PRIORITY);
        parentThread.setPriority(Thread.MIN_PRIORITY);
        parentThread.start();
        childThread.start();
    }
}
