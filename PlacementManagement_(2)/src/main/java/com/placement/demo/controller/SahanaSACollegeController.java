package com.placement.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.DTO.SahanaDTO;
import com.placement.demo.model.RahulUser;
import com.placement.demo.model.SahanaSACollege;
import com.placement.demo.service.RahulUserService;
import com.placement.demo.service.SahanaSACollegeService;

@RestController
public class SahanaSACollegeController {

	@Autowired
	private SahanaSACollegeService service;
	
	@Autowired
	private RahulUserService userservice;
	
	//Retrieval
	@GetMapping("/colleges")
	public List<SahanaSACollege> list(){
		return service.listAll();
	}
	
	//Retrieve By Id
	@GetMapping("/colleges/{id}")
	public ResponseEntity <SahanaDTO> get(@PathVariable Integer id){
		try {
			SahanaSACollege product = service.get(id);
			RahulUser user = userservice.get(product.getUser_Id());
			return new ResponseEntity<SahanaDTO>(new SahanaDTO(product.getCollege_id(),product.getCollegeAdmin(),product.getCollegeName(),product.getLocation(),user),HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<SahanaDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Create
	@PostMapping("/colleges")
	public void add(@RequestBody SahanaSACollege product) {
		service.save(product);
			}
			
	// RESTful API method for Update operation
//	@SuppressWarnings("unused")
	@PutMapping("/colleges/{id}")
	 public ResponseEntity<?> update(@RequestBody SahanaSACollege product, @PathVariable Integer id) 
	 {
		try
	    {
			SahanaSACollege existCollegeService = service.get(id);
			service.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 // RESTful API method for Delete operation
	 @DeleteMapping("/colleges/{id}")
	 public void delete(@PathVariable Integer id) 
	 {
		 service.delete(id);
	 }
			
		}
	
	
	
	
