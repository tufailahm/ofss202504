package threaddemos;

public class Demo1 implements Runnable
{
    Thread t1;
    public Demo1(){
        t1 = new Thread(this);
        t1.setName("MUSICTHREAD");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }
    @Override
    public void run()
    {

        System.out.println("1. RUN CALLED  :: "+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        Thread.currentThread().setName("GAMESTHREAD");
        new Demo1();
        System.out.println("1. MAIN CALLED  :: "+Thread.currentThread().getName());
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("2. RUN CALLED  :: "+Thread.currentThread().getName());
            }
        };
        t.setName("SCORESTHREAD");


        Runnable r = () -> {
            System.out.println("PARENTS NAME  :: "+Thread.currentThread().getName());
        };
        Thread t2 = new Thread(r);


        t.start();
        t2.start();
    }

}
