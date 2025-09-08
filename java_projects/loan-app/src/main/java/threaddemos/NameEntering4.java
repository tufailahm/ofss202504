package threaddemos;

import java.util.Scanner;

//not working because we are using Scanner
public class NameEntering4 extends Thread {
    private volatile String name = null;
    private volatile boolean inputReceived = false;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name (within 10 seconds): ");

        try {
            if (sc.hasNextLine()) {  // Wait until the user types something
                name = sc.nextLine();
                inputReceived = true;
            }
        } catch (Exception e) {
            // Ignore interruptions
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NameEntering4 t1 = new NameEntering4();
        t1.start();

        // Wait for max 10 seconds
        t1.join(10000);

        if (t1.inputReceived && t1.name != null && !t1.name.isEmpty()) {
            System.out.println("Hello, " + t1.name + "!");
        } else {
            System.out.println("Better luck next time!");
        }

        // Interrupt input thread if still running
        if (t1.isAlive()) {
            t1.interrupt();
        }

        System.out.println("Program finished!");
    }
}
