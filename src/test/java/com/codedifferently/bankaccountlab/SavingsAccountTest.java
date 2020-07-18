package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
    SavingsAccount savingsAccount;

    @Before
    public void instantiate() {
        savingsAccount = new SavingsAccount();
    }

    @Test
    public void getNameTest() {
        String expected = "not set";

        String actual = savingsAccount.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        String expected = "Wachovia";

        savingsAccount.setName("Wachovia");
        String actual = savingsAccount.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRateTest() {
        double expected = 0.0;

        double actual = savingsAccount.getRate();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setRateTest() {
        double expected = 12.3;

        savingsAccount.setRate(12.3);
        double actual = savingsAccount.getRate();

        Assert.assertEquals(expected, actual, 0.0);
    }
}
