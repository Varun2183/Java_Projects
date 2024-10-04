package com.tnsif.placement.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import com.placement.demo.model.VarunAdmin;

class VarunAdminTest {

    // Test for the parameterized constructor and getter methods
    @Test
    void testParameterizedConstructorAndGetters() {
        // Create a new VarunAdmin instance
        VarunAdmin admin = new VarunAdmin(1, "John Doe", "password123");

        // Verify the field values
        assertEquals(1, admin.getId());  // Verifying that the id is correctly set
        assertEquals("John Doe", admin.getName());
        assertEquals("password123", admin.getPassword());

        System.out.println("testParameterizedConstructorAndGetters passed successfully.");
    }
    
    // Test for the setter methods
    @Test
    void testSetters() {
        VarunAdmin admin = new VarunAdmin(); // Create a new VarunAdmin instance
        admin.setId(1);
        admin.setName("Jane Doe");
        admin.setPassword("password123");

        assertEquals(1, admin.getId());
        assertEquals("Jane Doe", admin.getName());
        assertEquals("password123", admin.getPassword());

        System.out.println("testSetters passed successfully.");
    }
    
    // Test for the toString method (optional, if you override toString)
    @Test
    void testToString() {
        VarunAdmin admin = new VarunAdmin(1, "John Doe", "password123");
        String expectedString = "VarunAdmin [id=" + admin.getId() + ", name=" + admin.getName() + ", password=" + admin.getPassword() + "]";

        assertEquals(expectedString, admin.toString());
        System.out.println("testToString passed successfully; expected and actual VarunAdmin details are the same.");
    }
    
    // Test for asserting not null
    @Test
    void testAssertNotNull() {
        VarunAdmin admin = new VarunAdmin(1, "John Doe", "password123");
        assertNotNull(admin.getId());
        System.out.println("testAssertNotNull passed successfully; id is not null.");
    }

    // Test for asserting null (if applicable)
    @Test
    void testAssertNull() {
        VarunAdmin admin = new VarunAdmin(1, null, null);
        assertNull(admin.getName());
        assertNull(admin.getPassword());
        System.out.println("testAssertNull passed successfully; admin name and password are null.");
    }
    
    // Test for asserting false
    @Test
    void testAssertFalse() {
        VarunAdmin admin = new VarunAdmin(1, "John Doe", "password123");
        assertFalse(admin.getName().contains("V"));
        System.out.println("testAssertFalse passed successfully; admin name does not contain 'V'.");
    }
    
    @Test
    void testAssumeTrue() {
        VarunAdmin admin = new VarunAdmin(1, "John Doe", "password123");
        Assumptions.assumeTrue("John Doe".equals(admin.getName()), "yes, admin name is John Doe"); 
    }
}
