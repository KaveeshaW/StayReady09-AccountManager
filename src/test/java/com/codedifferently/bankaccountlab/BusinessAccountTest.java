package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessAccountTest {
    BusinessAccount buisnessAccount;

    @Before
    public void instantiate() {
        buisnessAccount = new BusinessAccount();
    }

    @Test
    public void getNameTest() {
        String expected = "not set";

        String actual = buisnessAccount.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        String expected = "Wachovia";

        buisnessAccount.setName("Wachovia");
        String actual = buisnessAccount.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRateTest() {
        double expected = 0.0;

        double actual = buisnessAccount.getRate();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setRateTest() {
        double expected = 12.3;

        buisnessAccount.setRate(12.3);
        double actual = buisnessAccount.getRate();

        Assert.assertEquals(expected, actual, 0.0);
    }
}
