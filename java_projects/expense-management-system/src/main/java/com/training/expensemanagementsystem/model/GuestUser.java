package com.training.expensemanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="guestuser")
public class GuestUser {

    @Id
    private Long guestId;
    private String guestName;
    private String mobileNumber;
    private Double monthlyIncome;
    private Double monthlyExpense;
    private Double balance;

    // Default constructor
    public GuestUser() {}

    // All-args constructor
    public GuestUser(Long guestId, String guestName, String mobileNumber,
                 Double monthlyIncome, Double monthlyExpense, Double balance) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.mobileNumber = mobileNumber;
        this.monthlyIncome = monthlyIncome;
        this.monthlyExpense = monthlyExpense;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(Double monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "guestId=" + guestId +
                ", guestName='" + guestName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", monthlyExpense=" + monthlyExpense +
                ", balance=" + balance +
                '}';
    }
}
