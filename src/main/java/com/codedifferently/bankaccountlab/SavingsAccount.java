package com.codedifferently.bankaccountlab;

public class SavingsAccount extends BankAccount{
    private String name;
    private double rate;

    public SavingsAccount(String password) {
        super(password);
        name = "not set";
        rate = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return super.toString() + " Your name: " + getName() + " rate: " + getRate();
    }
}
