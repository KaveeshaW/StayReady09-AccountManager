package com.codedifferently.bankaccountlab;

import java.util.UUID;
import java.util.logging.Logger;

//abstract class because you can have instance variables that each class inherits
public abstract class BankAccount {
    public final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //every subclass has these fields
    protected UUID accountNumber = UUID.randomUUID();
    protected double annualFees = 0.0;
    protected String name = "not set";
    protected double balance = 0.0;

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public double getAnnualFees() {
        return annualFees;
    }

    public void setAnnualFees(double fees) {
        annualFees = fees;
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

    public void makeDeposit(double amount) {
        if(amount < 0) {
            LOGGER.info("You cannot make a negative deposit. Try again");
        }
        else {
            setBalance(amount);
            LOGGER.info("Your balance is now: " + balance);
        }
    }

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
