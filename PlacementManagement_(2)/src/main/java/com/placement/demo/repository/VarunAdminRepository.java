package com.placement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.demo.model.VarunAdmin;

public interface VarunAdminRepository extends JpaRepository<VarunAdmin,Integer> {
	
}