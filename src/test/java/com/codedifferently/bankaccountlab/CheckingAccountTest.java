package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    CheckingAccount checkingAccount;

    @Before
    public void instantiate() {
        checkingAccount = new CheckingAccount("peanut");
    }

    @Test
    public void getNameTest() {
        String expected = "not set";

        String actual = checkingAccount.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        String expected = "Bill";

        checkingAccount.setName("Bill");
        String actual = checkingAccount.getName();

        Assert.assertEquals(expected, actual);
    }
}
