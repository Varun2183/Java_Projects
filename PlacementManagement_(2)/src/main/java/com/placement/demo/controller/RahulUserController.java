package com.placement.demo.controller;

import java.util.List;


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

import com.placement.demo.DTO.RahulDTO;
import com.placement.demo.model.RahulUser;
import com.placement.demo.model.VarunAdmin;
import com.placement.demo.service.RahulUserService;
import com.placement.demo.service.VarunAdminService;

@RestController
public class RahulUserController {

	@Autowired
	private RahulUserService userservice;
	
	@Autowired
	private VarunAdminService adminservice;
	
	//Retrieval
	@GetMapping("/users")
	public List<RahulUser> list(){
		return userservice.listAll();
	}
	
	//Retrieve by Id
	@GetMapping("/users/{id}")
	public ResponseEntity <RahulDTO> get(@PathVariable Integer id){
		try {
			RahulUser user = userservice.get(id);
			VarunAdmin v=adminservice.get(user.getAdminId());
			 
//			return new ResponseEntity<RahulDTO>(new RahulDTO(user.getId(),user.getName(),user.getType(),user.getPassword(),v.getId(),v.getName()),HttpStatus.OK);
			return new ResponseEntity<RahulDTO>(new RahulDTO(user.getId(),user.getName(),user.getType(),user.getPassword(),v),HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<RahulDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create operation
	@PostMapping("/users")
	public void add(@RequestBody RahulUser user) {
		System.out.println("shata"+user);
		userservice.create(user);
	}
	
	//Update
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@RequestBody RahulUser user,@PathVariable Integer id){
		try {
			RahulUser presentuser = userservice.get(id);
			userservice.create(user);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		userservice.delete(id);
	}
}
