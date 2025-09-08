package com.training.softbankrestapi.model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

 private  int   accountNumber;
 private String customerName;
    private String mobileNumber;
            private double balance;

    public Account() {

    }

    public Account(int accountNumber, String customerName, String mobileNumber, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "accountNumber=" + accountNumber +
                ", customerName='" + customerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber && Double.compare(balance, account.balance) == 0 && Objects.equals(customerName, account.customerName) && Objects.equals(mobileNumber, account.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, customerName, mobileNumber, balance);
    }
}
