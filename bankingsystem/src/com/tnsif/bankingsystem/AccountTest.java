package com.tnsif.bankingsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(101, 1, "Saving", 5000.0);
    }

    @Test
    void testGetters() {
        assertEquals(101, account.getAccountID());
        assertEquals(1, account.getCustomerID());
        assertEquals("Saving", account.getType());
        assertEquals(5000.0, account.getBalance());
    }

    @Test
    void testSetters() {
        account.setType("Current");
        assertEquals("Current", account.getType());

        account.setBalance(10000.0);
        assertEquals(10000.0, account.getBalance());
    }

    @Test
    void testToString() {
        String expected = "Account [accountID=101, customerID=1, type=Saving, balance=5000.0]";
        assertEquals(expected, account.toString());
    }
}
