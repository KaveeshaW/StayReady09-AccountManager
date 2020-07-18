package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount{
    private String name;
    private double rate;

    public BusinessAccount() {
        super();
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
}
