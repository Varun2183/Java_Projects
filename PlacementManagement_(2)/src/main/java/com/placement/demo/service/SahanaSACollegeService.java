package com.placement.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placement.demo.model.SahanaSACollege;
import com.placement.demo.repository.SahanaSACollegeRepository;

@Service
@Transactional
public class SahanaSACollegeService {

	@Autowired
	private SahanaSACollegeRepository repository;
	
	public List<SahanaSACollege> listAll(){
		return repository.findAll();
	}
	
	public SahanaSACollege get(Integer id) {
		return repository.findById(id).get();
	}
	
	public void save(SahanaSACollege product) {
		repository.save(product);
	}
	

	public void delete(Integer id) {
		repository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	
	
	
}
