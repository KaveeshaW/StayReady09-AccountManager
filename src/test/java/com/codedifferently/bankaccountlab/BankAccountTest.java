package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class BankAccountTest {
    BankAccount checkingAccount;

    @Before
    public void instantiate() {
        checkingAccount = new CheckingAccount("123");
    }

    @Test
    public void getAccountNumberTest() {
        UUID randomAccountNumber = UUID.randomUUID();

        UUID actualAccountNumber = checkingAccount.getAccountNumber();

        Assert.assertNotEquals(randomAccountNumber, actualAccountNumber);;
    }

    @Test
    public void getAnnualFeesTest() {
        double expected = 0.0;

        double actual = checkingAccount.getAnnualFees();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setAnnualFeesTest() {
        double expected = 120.0;

        //amount of fees for typical checking account
        checkingAccount.setAnnualFees(120.0);
        double actual = checkingAccount.getAnnualFees();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getBalanceTest() {
        double expected = 0.0;

        double actual = checkingAccount.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setBalanceTest() {
        double expected = 12.0;

        checkingAccount.setBalance(12.0);
        double actual = checkingAccount.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makeNegativeDepositTest() {
        double expected = 0.0;

        checkingAccount.makeDeposit(-12);
        double actual = checkingAccount.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makePositiveDepositTest() {
        double expected = 15.0;

        checkingAccount.makeDeposit(15.0);
        double actual = checkingAccount.getBalance();

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makeNegativeWithdrawalTest() {
        double expected = 0.0;

        double actual = checkingAccount.makeWithdrawal(-3);

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void makePositiveWithdrawalTest() {
        double expected = 7.5;

        checkingAccount.makeDeposit(15.0);
        double actual = checkingAccount.makeWithdrawal(7.5);

        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getPasswordTest() {
        String expected = "123";

        String actual = checkingAccount.getPassword();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPasswordTest() {
        String expected = "Shepard Pie";

        checkingAccount.setPassword("Shepard Pie");
        String actual = checkingAccount.getPassword();

        Assert.assertEquals(expected, actual);
    }
}
