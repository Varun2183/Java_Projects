package com.tnsif.bankingsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	private Customer customer;
	
	@BeforeEach
    void setUp() {
        customer = new Customer(1, "John Doe", "123 Main St", "1234567890");
    }
	@Test
    void testGetters() {
        assertEquals(1, customer.getCustomerID());
        assertEquals("John Doe", customer.getName());
        assertEquals("123 Main St", customer.getAddress());
        assertEquals("1234567890", customer.getContact());
    }

    @Test
    void testSetters() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());

        customer.setAddress("456 Market St");
        assertEquals("456 Market St", customer.getAddress());

        customer.setContact("0987654321");
        assertEquals("0987654321", customer.getContact());
    }

    @Test
    void testToString() {
        String expected = "Customer [customerID=1, name=John Doe, address=123 Main St, contact=1234567890]";
        assertEquals(expected, customer.toString());
    }
}

