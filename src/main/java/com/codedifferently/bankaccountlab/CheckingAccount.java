package com.codedifferently.bankaccountlab;

import java.util.UUID;

public class CheckingAccount extends BankAccount{
    private final UUID ACCOUNT_NUMBER;
    private final double ANNUAL_FEES;
    private String name;
    private double balance;

    public CheckingAccount(CheckingAccountDetail detail) {
        this.ACCOUNT_NUMBER = detail.accountNumber;
        this.ANNUAL_FEES = detail.annualFees;
        this.name = detail.name;
        this.balance = detail.balance;
    }

    public UUID getAccountNumber() {
        return ACCOUNT_NUMBER;
    }

    public double getAnnualFeesFees() {
        return ANNUAL_FEES;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "accountNumber: " + this.ACCOUNT_NUMBER + " fees: " + this.ANNUAL_FEES + " name: " + this.name + " balance: " + this.balance;
    }

    @Override
    public void makeDeposit(double amount) {
        if(amount < 0) {
            LOGGER.info("You cannot make a negative deposit. Try again");
        }
        else {
            setBalance(amount);
            LOGGER.info("Your balance is now: " + balance);
        }
    }

    @Override
    public double makeWithdrawal(double amount) {
        if(amount < 0) {
            LOGGER.info("Cannot make a withdrawal because it results in a value less than 0\nReturning 0 because there is nothing to withdraw");
            return 0.0;
        }
        else {
            double amountToSubtract = -amount;
            setBalance(amountToSubtract);
        }
        return amount;
    }
}
