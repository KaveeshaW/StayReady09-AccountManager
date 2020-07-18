package com.codedifferently.bankaccountlab;

public class SavingsAccount extends BankAccount{
    private final int accountNumber;
    private double fees;
    private String name;
    private double rate;
    private double balance;

    public SavingsAccount(SavingsAccountDetails details) {
        accountNumber = details.accountNumber;
        fees = details.fees;
        name = details.name;
        rate = details.rate;
        balance = details.balance;
    }

    @Override
    public void makeDeposit(double amount) {
        LOGGER.info("placeholder");
    }

    @Override
    public double makeWithdrawal(double amount) {
        return 0;
    }

}
