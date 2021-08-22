package com.company;

public class Balance_Exception extends Exception {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public Balance_Exception(String message, int x) {
        super(message);
        balance = x;
    }
}