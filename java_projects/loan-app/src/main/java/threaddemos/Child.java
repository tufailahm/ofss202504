package threaddemos;

public class Child implements Runnable{

    Thread t;

    public Child(){
        t = new Thread(this);
        t.setPriority(1);
        t.setName("Child");
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Child run "+Thread.currentThread().getName());
        System.out.println("Child run");
        System.out.println("Child run");
    }
}
