package threaddemos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo4 {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello Tufail"+Thread.currentThread().getName());
        };
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        ses.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        ExecutorService es  = Executors.unconfigurableExecutorService(ses);
        es.submit(task);

    }
}
