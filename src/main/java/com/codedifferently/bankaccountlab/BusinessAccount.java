package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount{
    @Override
    public void makeDeposit(double amount) {
        LOGGER.info("placeholder");
    }

    @Override
    public double makeWithdrawal(double amount) {
        return 0;
    }
}
