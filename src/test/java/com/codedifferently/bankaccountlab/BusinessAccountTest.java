package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessAccountTest {
    BusinessAccount businessAccount;

    @Before
    public void instantiate() {
        businessAccount = new BusinessAccount();
    }

    @Test
    public void getCompanyTest() {
        String expected = "not known";

        String actual = businessAccount.getCompanyName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCompanyTest() {
        String expected = "Wells Fargo";

        businessAccount.setCompanyName("Wells Fargo");
        String actual = businessAccount.getCompanyName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTaxIDTest() {
        int expected = 0;

        int actual = businessAccount.getTaxID();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setIDTest() {
        int expected = 123456789;

        businessAccount.setTaxID(123456789);
        int actual = businessAccount.getTaxID();

        Assert.assertEquals(expected, actual);
    }
}
