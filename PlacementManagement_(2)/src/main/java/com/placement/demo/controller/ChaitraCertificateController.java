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

import com.placement.demo.DTO.ChaitraDTO;
import com.placement.demo.model.ChaitraCertificate;
import com.placement.demo.model.SahanaSACollege;
import com.placement.demo.service.ChaitraCertificateService;
import com.placement.demo.service.SahanaSACollegeService;

@RestController
public class ChaitraCertificateController {
	
	@Autowired
	private ChaitraCertificateService certificateservice;
	
	@Autowired
	private SahanaSACollegeService service;
	
	//Retrieval
	@GetMapping("/certificates")
	public List<ChaitraCertificate> list(){
		return certificateservice.listAll();
	}
	
	//Retrieve by Id
	@GetMapping("/certificates/{id}")
	public ResponseEntity <ChaitraDTO> get(@PathVariable Integer id){
		try {
			ChaitraCertificate certi = certificateservice.get(id);
			SahanaSACollege college = service.get(certi.getCollege_id());
			
			return new ResponseEntity<ChaitraDTO>(new ChaitraDTO(certi.getId(),certi.getYear(),certi.getCollege(),college),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<ChaitraDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create operation
	@PostMapping("/certificates")
	public void add(@RequestBody ChaitraCertificate chaitraCertificate) {
		certificateservice.create(chaitraCertificate);
	}
	
	//Update
	@PutMapping("/certificates/{id}")
	public ResponseEntity<?> update(@RequestBody ChaitraCertificate chaitraCertificate,@PathVariable Integer id){
		try {
			certificateservice.create(chaitraCertificate);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/certificates/{id}")
	public void delete(@PathVariable Integer id) {
		certificateservice.delete(id);
	}
}


