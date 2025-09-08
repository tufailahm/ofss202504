package threaddemos;

import java.util.Scanner;
import java.util.concurrent.*;

class BankAccount {
    private double balance = 10000; // initial balance

    // Deposit method
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " → Deposited ₹" + amount + ". New Balance: ₹" + balance);
    }

    // Withdraw method
    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " → Withdrawn ₹" + amount + ". Remaining Balance: ₹" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " →  Insufficient balance! Current Balance: ₹" + balance);
        }
    }

    // Check balance method
    public synchronized void checkBalance() {
        System.out.println("Current Balance: ₹" + balance + " [Checked by " + Thread.currentThread().getName() + "]");
    }
}

public class ATMMachineSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        // Create ScheduledExecutorService for background tasks
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

        // Schedule background balance check every 5 seconds
        ses.scheduleAtFixedRate(() -> account.checkBalance(), 1, 5, TimeUnit.SECONDS);

        // Create unconfigurable executor for on-demand tasks
        ExecutorService es = Executors.unconfigurableExecutorService(ses);

        // Menu-driven ATM system
        while (true) {
            System.out.println("\n========= ATM MACHINE =========");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    es.submit(() -> account.deposit(depositAmount));
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    es.submit(() -> account.withdraw(withdrawAmount));
                    break;

                case 3:
                    es.submit(() -> account.checkBalance());
                    break;

                case 4:
                    System.out.println(" Exiting ATM. Thank you!");
                    ses.shutdown();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
