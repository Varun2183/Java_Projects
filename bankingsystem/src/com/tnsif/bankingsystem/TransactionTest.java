package com.tnsif.bankingsystem;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionTest {

	private Transaction transaction;
	@BeforeEach
    void setUp() {
        transaction = new Transaction(1, 101, "Deposit", 2000.0);
    }

    @Test
    void testGetters() {
        assertEquals(1, transaction.getTransactionID());
        assertEquals(101, transaction.getAccountID());
        assertEquals("Deposit", transaction.getType());
        assertEquals(2000.0, transaction.getAmount());
        assertNotNull(transaction.getTimestamp());
    }

    @Test
    void testSetters() {
        transaction.setType("Withdrawal");
        assertEquals("Withdrawal", transaction.getType());

        transaction.setAmount(1000.0);
        assertEquals(1000.0, transaction.getAmount());
    }

    @Test
    void testToString() {
        String expected = "Transaction [transactionID=1, accountID=101, type=Deposit, amount=2000.0, timestamp=";
        assertTrue(transaction.toString().startsWith(expected));
    }
}
