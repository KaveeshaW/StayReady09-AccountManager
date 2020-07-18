package com.codedifferently.bankaccountlab;

public class CheckingAccount extends BankAccount {
    private String name;

    public CheckingAccount() {
        super();
        name = "not set";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
