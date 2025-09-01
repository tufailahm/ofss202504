package com.training.com.training.model;

public record Customer(int customerId, String customerName, int bill){

    @Override
    public int bill() {
        return bill+100;
    }
}
