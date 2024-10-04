package com.placement.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placement.demo.model.VarunAdmin;
import com.placement.demo.repository.VarunAdminRepository;

@Service
@Transactional
public class VarunAdminService {

    @Autowired
    private VarunAdminRepository adminRepository;

    // Retrieve all Admins
    public List<VarunAdmin> listAll() {
        return adminRepository.findAll();
    }

    // Retrieve Admin by Id
    public VarunAdmin get(Integer id) {
    	 return adminRepository.findById(id).orElse(null);  // Returns null if not found
    }

    // Create or Update Admin
    public void create(VarunAdmin admin) {
        adminRepository.save(admin);
    }

    // Delete Admin by Id
    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }
    
   
}