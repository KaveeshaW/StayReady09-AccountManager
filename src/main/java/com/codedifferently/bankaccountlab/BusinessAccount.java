package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount{
    private String companyName;
    private int taxID;

    public BusinessAccount() {
        companyName = "not known";
        taxID = 0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTaxID() {
        return taxID;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }
}
