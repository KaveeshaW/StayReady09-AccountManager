package com.codedifferently.bankaccountlab;

public class CheckingAccount extends BankAccount {
    private String name;

    public CheckingAccount(String password) {
        super(password);
        name = "not set";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " Your name: " + getName();
    }
}
