package threaddemos;

import java.util.concurrent.*;
/*
When a Runnable object is passed to ExecutorService submit method, the returned Future object is not expected to actually contain any value, but can be used to find out when the run method completes processing.
When getting a value from the Future result object, the following exception can occur:
Callable<String> t = new Callable<>() {
   public String call() throws Exception {
             }};
ExecutorService es = Executors.newFixedThreadPool(10);
Future<String> result = es.submit(t);
try {
        */
public class Demo6 {
    public static void main(String[] args) {
        Callable<String> t = new Callable<>() {
            public String call() throws Exception {
                /* perform concurrent actions */
                return "some value";
            }};
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<String> result = es.submit(t);
        try {
            String value = result.get(10, TimeUnit.SECONDS);
        } catch(Exception e) {}

    }
}
