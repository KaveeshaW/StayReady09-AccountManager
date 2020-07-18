package com.codedifferently.bankaccountlab;
import java.util.UUID;

public class SavingsAccountDetails {
    //no need for getters and setters of this particular thing
    public UUID accountNumber = UUID.randomUUID();
    public double annualFees = 25.0;
    public String name = "not set";
    public double rate = 0.7;
    public double balance = 0.0;
}
