package com.tnsif.placement.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.placement.demo.model.VarunAdmin;
import com.placement.demo.repository.VarunAdminRepository;
import com.placement.demo.service.VarunAdminService;


class AdminServiceTest {

	@Mock
    private VarunAdminRepository adminRepository;

    @InjectMocks
    private VarunAdminService adminService;

    private VarunAdmin admin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);  // Initialize mocks

        admin = new VarunAdmin(1, "John Doe", "password123");  // Sample Admin instance
    }

    @Test
    void testListAll() {
        List<VarunAdmin> admins = Arrays.asList(admin);
        when(adminRepository.findAll()).thenReturn(admins);

        List<VarunAdmin> result = adminService.listAll();
        assertEquals(1, result.size());
        verify(adminRepository, times(1)).findAll();
    }

    @Test
    void testGetAdminById() {
        when(adminRepository.findById(1)).thenReturn(Optional.of(admin));

        VarunAdmin foundAdmin = adminService.get(1);
        assertNotNull(foundAdmin);
        assertEquals("John Doe", foundAdmin.getName());
        verify(adminRepository, times(1)).findById(1);
    }

    @Test
    void testCreateAdmin() {
        adminService.create(admin);
        verify(adminRepository, times(1)).save(admin);
    }

    @Test
    void testUpdateAdmin() {
        // Similar to create since the save method updates if the record exists
        adminService.create(admin);
        verify(adminRepository, times(1)).save(admin);
    }

    @Test
    void testDeleteAdmin() {
        adminService.delete(1);
        verify(adminRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetAdminById_NotFound() {
        when(adminRepository.findById(1)).thenReturn(Optional.empty());
        VarunAdmin notFoundAdmin = adminService.get(1);
        assertNull(notFoundAdmin);
        verify(adminRepository, times(1)).findById(1);
    }
}
