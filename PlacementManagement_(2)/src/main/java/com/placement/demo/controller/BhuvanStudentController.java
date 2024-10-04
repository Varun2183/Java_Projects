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

import com.placement.demo.DTO.BhuvanDTO;
import com.placement.demo.model.BhuvanStudent;
import com.placement.demo.model.ChaitraCertificate;
import com.placement.demo.model.SahanaSACollege;
import com.placement.demo.service.BhuvanStudentService;
import com.placement.demo.service.ChaitraCertificateService;
import com.placement.demo.service.SahanaSACollegeService;

@RestController
public class BhuvanStudentController {
	
	@Autowired
	private BhuvanStudentService service;
	
	@Autowired
	private ChaitraCertificateService certificateservice;
	
	@Autowired
	private SahanaSACollegeService collegeservice;
	
	
	//Retrieval
	@GetMapping("/students")
	public List<BhuvanStudent> list(){
		System.out.println("Inside GetMapping");
		return service.listAll();   
	}
	
	//Retrieve By Id
	@GetMapping("/students/{id}")
	public ResponseEntity <BhuvanDTO> get(@PathVariable Integer id){
		try {
			System.out.println("Fecthing Id"+id);
			BhuvanStudent student = service.get(id);
			System.out.println("student data - "+student);
			
			ChaitraCertificate c =certificateservice.get(student.getCertificate_Id());
			System.out.println("certificate - "+c);
			
			BhuvanStudent student1 = service.get(id);
			SahanaSACollege s = collegeservice.get(student1.getCollege_id());
			System.out.println("college details - "+s);
			
			return new ResponseEntity<BhuvanDTO>(new BhuvanDTO(student.getId(),student.getName(),student.getCollege(),student.getRollno(),student.getQualification(),student.getCourse(),student.getYear(),student.getCertificate(),student.getHallticketno(),c,s),HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<BhuvanDTO>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	//create
	@PostMapping("/students")
	public void add(@RequestBody BhuvanStudent student) {
		System.out.println("Posting"+student);
		service.save(student);
		
	}
	
	//Update
	@PutMapping("/students/{id}")
	public ResponseEntity<?> update(@RequestBody BhuvanStudent student,@PathVariable Integer id){
		try {
			System.out.println("Fecthing Id"+id+"Put Mapping"+student);
			BhuvanStudent existStudent = service.get(id);
			service.save(student);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Integer id) {
		System.out.println("Deleting Id"+id);
		service.delete(id);
	}

}
