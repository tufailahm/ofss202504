package threaddemos;

import java.util.Scanner;

public class ThreadingSolution {
    static volatile String name = null;

    public static void main(String[] args) {
        Thread inputThread = new Thread(() -> {
            System.out.println("Enter your name (within 10 seconds):");
            Scanner sc = new Scanner(System.in);
            try {
                name = sc.next();
            } catch (Exception e) {
                System.out.println("Error reading input.");
            }
        });

        inputThread.start();

        try {
            inputThread.join(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        if (name != null && !name.isEmpty()) {
            System.out.println("Welcome " + name);
            inputThread.interrupt();
        } else {
            System.out.println("Bye (no input received)");
            inputThread.interrupt(); 
        }
    }
}
