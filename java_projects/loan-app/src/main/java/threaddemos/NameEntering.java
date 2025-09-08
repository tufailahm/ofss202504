package threaddemos;

import java.io.IOException;
import java.util.Scanner;

//Working using System.in.read
//Auto Exit in 10 Seconds ( System.in.available)
public class NameEntering {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Enter your name (within 10 seconds): ");

        StringBuilder input = new StringBuilder();
        long start = System.currentTimeMillis();

        while ((System.currentTimeMillis() - start) < 10000) {
            // Check if user has typed anything
            if (System.in.available() > 0) {
                char ch = (char) System.in.read();
                if (ch == '\n') { // Enter key pressed
                    break;
                }
                input.append(ch);
            } else {
                Thread.sleep(100); // Reduce CPU usage
            }
        }

        if (input.length() > 0) {
            System.out.println("Hello, " + input.toString().trim() + "!");
        } else {
            System.out.println("Better luck next time!");
        }

        System.out.println("Program finished!");
    }
}
