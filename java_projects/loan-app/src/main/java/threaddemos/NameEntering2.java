package threaddemos;

import java.util.Scanner;

//Scanner - will not work
public class NameEntering2 extends Thread {
    private volatile boolean inputReceived = false;

    @Override
    public void run() {
        System.out.println("Enter your name (within 10 seconds): ");
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNextLine()) {
                String name = sc.nextLine();
                inputReceived = true;
                System.out.println("Hello, " + name + "!");
            }
        } catch (Exception e) {
            System.out.println("Input stopped!");
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NameEntering2 t1 = new NameEntering2();
        t1.start();

        // Wait for a maximum of 10 seconds
        t1.join(10000);

        // Check if input was received
        if (!t1.inputReceived) {
            System.out.println("Better luck next time!");
        }

        // Wait for thread to finish if still running
        if (t1.isAlive()) {
            t1.interrupt();
        }

        System.out.println("Program finished!");
    }
}
