package com.tnsif.bankingsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeneficiaryTest {

	 private Beneficiary beneficiary;

	    @BeforeEach
	    void setUp() {
	        beneficiary = new Beneficiary(1001, 1, "Alice", "9876543210", "XYZ Bank");
	    }

	    @Test
	    void testGetters() {
	        assertEquals(1001, beneficiary.getBeneficiaryID());
	        assertEquals(1, beneficiary.getCustomerID());
	        assertEquals("Alice", beneficiary.getName());
	        assertEquals("9876543210", beneficiary.getAccountNumber());
	        assertEquals("XYZ Bank", beneficiary.getBankDetails());
	    }

	    @Test
	    void testSetters() {
	        beneficiary.setName("Bob");
	        assertEquals("Bob", beneficiary.getName());

	        beneficiary.setAccountNumber("1234567890");
	        assertEquals("1234567890", beneficiary.getAccountNumber());
	    }

	    @Test
	    void testToString() {
	        String expected = "Beneficiary [beneficiaryID=1001, customerID=1, name=Alice, accountNumber=9876543210, bankDetails=XYZ Bank]";
	        assertEquals(expected, beneficiary.toString());
	    }
}
