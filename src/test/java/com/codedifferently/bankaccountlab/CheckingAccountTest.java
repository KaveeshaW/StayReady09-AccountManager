package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class CheckingAccountTest {
    CheckingAccountDetail detail;
    CheckingAccount account;

    @Before
    public void instantiate() {
        detail = new CheckingAccountDetail();
        account = new CheckingAccount(detail);
    }

    @Test
    public void getAccountNumberTest() {
        UUID randomAccountNumber = UUID.randomUUID();

        UUID actualAccountNumber = account.getAccountNumber();

        Assert.assertNotEquals(randomAccountNumber, actualAccountNumber);;
    }

    @Test
    public void getAnnualFeesTest() {
        double expected = 120.0;

        double actual = account.getAnnualFeesFees();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getNameTest() {
        String expected = "not set";

        String actual = account.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        String expected = "Bill";

        account.setName("Bill");
        String actual = account.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest() {
        double expected = 0.0;

        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setBalanceTest() {
        double expected = 12.0;

        account.setBalance(12.0);
        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makeNegativeDepositTest() {
        double expected = 0.0;

        account.makeDeposit(-12);
        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makePositiveDepositTest() {
        double expected = 15.0;

        account.makeDeposit(15.0);
        double actual = account.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makeNegativeWithdrawalTest() {
        double expected = 0.0;

        double actual = account.makeWithdrawal(-3);

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makePositiveWithdrawalTest() {
        double expected = 7.5;

        account.makeDeposit(15.0);
        double actual = account.makeWithdrawal(7.5);

        Assert.assertEquals(expected, actual, 0.0);
    }
}
