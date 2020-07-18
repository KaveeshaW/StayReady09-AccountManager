package com.codedifferently.bankaccountlab;

public class CheckingAccount extends BankAccount{
    private int accountNumber;
    private double fees;
    private String name;
    private double balance;

    public CheckingAccount(CheckingAccountDetail detail) {
        this.accountNumber = detail.accountNumber;
        this.fees = detail.fees;
        this.name = detail.name;
        this.balance = detail.balance;
    }
}
