package com.codedifferently.bankaccountlab;

import java.util.logging.Logger;

public abstract class BankAccount {
    public final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public abstract void makeDeposit(double amount);
    public abstract double makeWithdrawal(double amount);

}
