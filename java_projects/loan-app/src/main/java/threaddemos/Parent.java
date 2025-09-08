package threaddemos;

public class Parent implements Runnable{
    Thread t;

    Parent(){
        t = new Thread(this);
        t.setPriority(6);
        t.setName("Parent");
        t.start();
    }
	@Override
	public void run() {
        System.out.println("Parent run "+Thread.currentThread().getName());
        System.out.println("Parent run");
        System.out.println("Parent run");
    }
}

