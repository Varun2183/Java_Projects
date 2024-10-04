package com.tnsif.placement.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import com.placement.demo.model.*;

class Placementdemo {

	// Test for the parameterized constructor and getter methods
    @Test
    void testParameterizedConstructorAndGetters() {
        //Mall mall = new Mall(); // Create a new Mall instance
        RonitPlacement placement = new RonitPlacement(1, "dileep","Don Bosco", LocalDate.of(2025, 9, 25),"BE",2025, 701);

        // Assume the id is generated automatically, so we cannot check it right after creation
        assertNotNull(placement.getId()); // Verify that id is not null
        assertEquals(1, placement.getId()); // Checking ID
        assertEquals("dileep", placement.getName()); // Checking Name
        assertEquals("Don Bosco", placement.getCollege()); // Checking College
        assertEquals(LocalDate.of(2025, 9, 25), placement.getDate()); // Checking Date
        assertEquals("BE", placement.getQualification()); // Checking Qualification
        assertEquals(2025, placement.getYear());// Checking Year
        assertEquals(701, placement.getCollege_id());
        //assertEquals(mall, shopOwner.getMall());

        System.out.println("testParameterizedConstructorAndGetters passed successfully.");
    }

    // Test for the setter methods
    @Test
    void testSetters() {
        RonitPlacement placement = new RonitPlacement();
        //Mall mall = new Mall(); // Create a new Mall instance
        placement.setId(2);
        placement.setName("john doe");
        placement.setCollege("RV college");
        placement.setDate(LocalDate.of(2023, 6, 15));
        placement.setQualification("MTech");
        placement.setYear(2023);
        placement.setCollege_id(702);
        
        //shopOwner.setMall(mall);

        assertEquals(2, placement.getId()); // Checking ID
        assertEquals("john doe", placement.getName()); // Checking Name
        assertEquals("RV college", placement.getCollege()); // Checking College
        assertEquals(LocalDate.of(2023, 6, 15), placement.getDate()); // Checking Date
        assertEquals("MTech", placement.getQualification()); // Checking Qualification
        assertEquals(2023, placement.getYear()); // Checking Year
        assertEquals(702,placement.getCollege_id());
        //assertEquals(mall, shopOwner.getMall());

        System.out.println("testSetters passed successfully.");
    }
    
    // Test for asserting not null
    @Test
    void testAssertNotNull() {
        //Mall mall = new Mall(); // Create a new Mall instance
    	RonitPlacement placement = new RonitPlacement(1, "dileep","Don Bosco", LocalDate.of(2025, 9, 25),"BE",2025, 701);
    	assertNotNull(placement.getId()); // Check if ID is not null
        assertNotNull(placement.getName()); // Check if Name is not null
        assertNotNull(placement.getCollege()); // Check if College is not null
        assertNotNull(placement.getDate()); // Check if Date is not null
        assertNotNull(placement.getQualification()); // Check if Qualification is not null
        assertNotNull(placement.getYear());// Check if Year is not null
        assertNotNull(placement.getCollege_id());
        System.out.println("test AssertNotNull passed successfully; id is not null.");
    }

    // Test for asserting null (if applicable)
    @Test
    void testAssertNull() {
    	RonitPlacement placement = new RonitPlacement(1, "dileep",null,null,"BE",null,null);
        assertNull(placement.getName()); // Check if Name is null
        assertNull(placement.getCollege()); // Check if College is null
        assertNull(placement.getDate()); // Check if Date is null
        assertNull(placement.getYear());// Check if Year is null
        assertNull(placement.getCollege_id());
        System.out.println("testAssertNull passed successfully; shop owner name is null.");
    }

    // Test for asserting false
    @Test
    void testAssertFalse() {
        
    	RonitPlacement placement = new RonitPlacement(101, "Ronit V Raghavan","Don Bosco", LocalDate.of(2021, 12, 10),"BE",2025,705);
        assertFalse(placement.getName().contains("Z"));
        System.out.println("testAssertFalse passed successfully; student name does not contain 'Z'.");
    }
    
    @Test
    void testAssumeTrue() {
        //Mall mall = new Mall(); // Create a new Mall instance
    	RonitPlacement placement = new RonitPlacement(101, "Ronit V Raghavan","Don Bosco", LocalDate.of(2021, 12, 10),"BE",2025,701);
        
    	// Assumption for ID
        Assumptions.assumeTrue(placement.getId() == 101, "Assumption passed: ID is 101");

        // Assumption for Name
        Assumptions.assumeTrue("Ronit V Raghavan".equals(placement.getName()), "Assumption passed: Name is 'Ronit V Raghavan'");

        // Assumption for College
        Assumptions.assumeTrue("Don Bosco".equals(placement.getCollege()), "Assumption passed: College is 'Don Bosco'");

        // Assumption for Date
        Assumptions.assumeTrue(LocalDate.of(2021, 12, 10).equals(placement.getDate()), "Assumption passed: Date is 2021-12-10");

        // Assumption for Qualification
        Assumptions.assumeTrue("BE".equals(placement.getQualification()), "Assumption passed: Qualification is 'BE'");

        // Assumption for Year
        Assumptions.assumeTrue(placement.getYear() == 2025, "Assumption passed: Year is 2025");

    }

}

