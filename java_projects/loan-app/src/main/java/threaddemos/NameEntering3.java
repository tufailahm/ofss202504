package threaddemos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Working because we used BufferedReader
public class NameEntering3 extends Thread {
    private volatile String name = null;

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name (within 10 seconds): ");

            // Keep checking for interruption before reading
            while (!Thread.currentThread().isInterrupted()) {
                if (br.ready()) {  // Check if user typed something
                    name = br.readLine();
                    break;
                }
                Thread.sleep(100); // Small delay to reduce CPU usage
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("NameEntering run interrupted");
            // Thread interrupted or IO error → exit silently
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NameEntering3 t1 = new NameEntering3();
        t1.start();

        // Wait for max 10 seconds
        t1.join(10000);

        if (t1.name != null && !t1.name.isEmpty()) {
            System.out.println("Hello, " + t1.name + "!");
        } else {
            System.out.println("Better luck next time!");
        }

        // Interrupt the input thread if it's still running
        if (t1.isAlive()) {
            t1.interrupt();
        }

        System.out.println("Program finished!");
    }
}
