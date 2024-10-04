package com.tnsif.placement.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import com.placement.demo.model.BhuvanStudent;
class StudentTest {

    // Test for the parameterized constructor and getter methods
    @Test
    void testParameterizedConstructorAndGetters() {
        // Student 1: Bhuvan
        BhuvanStudent student1 = new BhuvanStudent(1, "Bhuvan", "Don Bosco", "12345", "BE", "CSE(AI & ML)", 2025, "Advance ML", 987654, 1001, 701);

        assertEquals(1, student1.getId());
        assertEquals("Bhuvan", student1.getName());
        assertEquals("Don Bosco", student1.getCollege());
        assertEquals("12345", student1.getRollno());
        assertEquals("BE", student1.getQualification());
        assertEquals("CSE(AI & ML)", student1.getCourse());
        assertEquals(2025, student1.getYear());
        assertEquals("Advance ML", student1.getCertificate());
        assertEquals(987654, student1.getHallticketno());
        assertEquals(1001, student1.getCertificate_Id());
        assertEquals(701, student1.getCollege_id());

        System.out.println("testParameterizedConstructorAndGetters for Student 1 passed successfully.");
    }

    // Test for the setter methods
    @Test
    void testSetters() {
        // Student 2: Ronit
    	BhuvanStudent student2 = new BhuvanStudent();
        student2.setId(2);
        student2.setName("Ronit");
        student2.setCollege("Don Bosco");
        student2.setRollno("54321");
        student2.setQualification("BE");
        student2.setCourse("CSE(AI & ML)");
        student2.setYear(2025);
        student2.setCertificate("Advance AI");
        student2.setHallticketno(123456);
        student2.setCertificate_Id(1001);
        student2.setCollege_id(701);

        assertEquals(2, student2.getId());
        assertEquals("Ronit", student2.getName());
        assertEquals("Don Bosco", student2.getCollege());
        assertEquals("54321", student2.getRollno());
        assertEquals("BE", student2.getQualification());
        assertEquals("CSE(AI & ML)", student2.getCourse());
        assertEquals(2025, student2.getYear());
        assertEquals("Advance AI", student2.getCertificate());
        assertEquals(123456, student2.getHallticketno());
        assertEquals(1001, student2.getCertificate_Id());
        assertEquals(701, student2.getCollege_id());

        System.out.println("testSetters for Student 2 passed successfully.");
    }

    // Test for the toString method (optional, if you override toString)
    @Test
    void testToString() {
    	BhuvanStudent student1 = new BhuvanStudent(1, "Bhuvan", "Don Bosco", "12345", "BE", "CSE(AI & ML)", 2025, "Advance ML", 987654,1001,701);
        // Assuming you implement a proper toString in Student
        String expectedString = "Student [id=1, name=Bhuvan, college=Don Bosco, rollno=12345, qualification=BE, course=CSE(AI & ML), year=2025, certificate=Advance ML, hallticketno=987654]";
        
        assertEquals(expectedString, student1.toString());
        System.out.println("testToString for Student 1 passed successfully; expected and actual student details are the same.");
    }

    // Test for asserting not null
    @Test
    void testAssertNotNull() {
    	BhuvanStudent student1 = new BhuvanStudent(1, "Bhuvan", "Don Bosco", "12345", "BE", "CSE(AI & ML)", 2025, "Advance ML", 987654,1001,701);
        assertNotNull(student1.getId());
        System.out.println("testAssertNotNull passed successfully; student ID is not null.");
    }

    // Test for asserting null (if applicable)
    @Test
    void testAssertNull() {
        BhuvanStudent student1 = new BhuvanStudent(1, "Bhuvan", "Don Bosco", null, "BE", "CSE(AI & ML)", 2025, "Advance ML", 987654,1001,701);
        assertNull(student1.getRollno());
        System.out.println("testAssertNull passed successfully; roll number is null.");
    }

    // Test for asserting false
    @Test
    void testAssertFalse() {
        BhuvanStudent student1 = new BhuvanStudent(1, "Bhuvan", "Don Bosco", "12345", "BE", "CSE(AI & ML)", 2025, "Advance ML", 987654,1001,701);
        assertFalse(student1.getName().contains("V"));
        System.out.println("testAssertFalse passed successfully; student name does not contain 'V'.");
    }

    // Test with assumption
    @Test
    void testAssumeTrue() {
    	BhuvanStudent student1 = new BhuvanStudent(1, "Bhuvan", "Don Bosco", "12345", "BE", "CSE(AI & ML)", 2025, "Advance ML", 987654,1001,701);
        Assumptions.assumeTrue("Bhuvan".equals(student1.getName()), "Assumption passed: Name is Bhuvan");
    }
}
