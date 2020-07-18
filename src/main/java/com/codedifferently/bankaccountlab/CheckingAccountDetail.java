package com.codedifferently.bankaccountlab;
import java.util.UUID;

public class CheckingAccountDetail {
    //no need for getters and setters of this particular thing
    public UUID accountNumber = UUID.randomUUID();
    public double annualFees = 120.0;
    public String name = "not set";
    public double balance = 0.0;
}
