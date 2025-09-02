package com.training;

import com.training.dao.AccountDAO;
import com.training.dao.AccountDAOImpl;
import com.training.exceptions.InvalidAmountException;
import com.training.model.Account;
import com.training.model.AuthenticateAccountBalance;
import com.training.util.OracleDBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Scanner  sc = new Scanner(System.in);
        AccountDAO accountDAO = new AccountDAOImpl();

        System.out.println("Welcome in ----------SOFT BANK");
        while (true) {
            System.out.println("\n===== ACCOUNT MANAGEMENT MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Search Account");
            System.out.println("6. Transfer Money");

            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    String mobile = sc.next();
                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    if(accountDAO.isAccountExists(accNo)){
                        System.out.println("Account already exists with account number: " + accNo);
                    }
                    else {
                        Account account = new  Account(accNo, name, mobile, balance);


                        accountDAO.createAccount(account);
                        System.out.println("Account created successfully");

                    }
                    break;
                case 2:
                    System.out.println(accountDAO.getAccount()); break;
                case 3: break;
                case 4:  break;
                case 5:
                    System.out.print("Enter Account Number: ");
                     accNo = sc.nextInt();
                    if(accountDAO.isAccountExists(accNo)){
                       Account account = accountDAO.getAccount(accNo);
                        System.out.println(account);
                    }
                    else {
                        System.out.println("Account does not exists");
                    }
                    break;
                case 6:
                    int faccno = 0;
                    int taccno = 0;
                    double bal = 0;

                    System.out.println("Enter from account Number:");
                    faccno = sc.nextInt();
                    System.out.println("Enter to account number:");
                    taccno = sc.nextInt();
                    System.out.println("Enter amount:");
                    bal = sc.nextDouble();

                    try {
                        if(bal<0)
                            //bring an exception
                        {
                            throw new InvalidAmountException("Negative amount is not allowed");
                        }
                    } catch (InvalidAmountException e) {
                        System.out.println(e.getMessage());
                    }


                    if(accountDAO.isAccountExists(faccno)!=true || accountDAO.isAccountExists(taccno)!=true){
                        System.out.println("Account doesn't exist");
                    }
                    else{
                        boolean ans = accountDAO.transfer(faccno,taccno,bal);
                        if(ans == true){
                            System.out.println("Transfer success");
                        }
                        else{
                            System.out.println("Error in transfer");
                        }
                    }
                    break;
                case 0:

                    sc.close();
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println(" Invalid Choice! Please try again.");
            }
        }
    }
}
