package com.placement.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.demo.model.BhuvanStudent;
//import org.springframework.transaction.annotation.Transactional;
import com.placement.demo.repository.BhuvanStudentRepository;

@Service
//@Transactional
public class BhuvanStudentService {
	
    @Autowired
	private BhuvanStudentRepository repository;
    
    public List<BhuvanStudent> listAll(){
    	return repository.findAll();
    	
    }
    
    public BhuvanStudent get(Integer id) {
    	return repository.findById(id).get();
    }
    
    public void save(BhuvanStudent student) {
    	repository.save(student);
    	
    }
    
    public void delete(Integer id) {
    	repository.deleteById(id);
    	
    }
    
}
