package com.placement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.placement.demo.model.VarunAdmin;
import com.placement.demo.service.VarunAdminService;

@RestController
@RequestMapping("/admin")
public class VarunAdminController {

    @Autowired
    private VarunAdminService adminService;

    // Retrieve all Admins
    @GetMapping
    public List<VarunAdmin> list() {
        return adminService.listAll();
    }

    // Retrieve Admin by Id
    @GetMapping("/{id}")
    public ResponseEntity<VarunAdmin> get(@PathVariable Integer id) {
        try {
        	VarunAdmin admin = adminService.get(id);
            return new ResponseEntity<VarunAdmin>(admin, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<VarunAdmin>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Create Admin
    @PostMapping
    public void add(@RequestBody VarunAdmin admin) {
        adminService.create(admin);
    }

    // Update Admin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody VarunAdmin admin, @PathVariable Integer id) {
        try {
        	VarunAdmin existingAdmin = adminService.get(id);  // Find existing Admin by ID
            admin.setId(id);  // Make sure the ID is the same
            adminService.create(admin);  // Update the Admin record
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            adminService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}