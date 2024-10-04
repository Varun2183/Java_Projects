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

import com.placement.demo.DTO.RonitDTO;
import com.placement.demo.model.RonitPlacement;
import com.placement.demo.model.SahanaSACollege;
import com.placement.demo.service.RonitPlacementService;
import com.placement.demo.service.SahanaSACollegeService;


@RestController
public class RonitPlacementController {

	@Autowired
	private RonitPlacementService service;
	
	@Autowired
	private SahanaSACollegeService collegeservice;
	
	//Retrieval all
	@GetMapping("/placements")
	public List<RonitPlacement> list(){
		System.out.println("Inside get mapping");
		return service.listAll();
	}
	
	//Retrieve by ID
	@GetMapping("/placements/{id}")
	public ResponseEntity <RonitDTO> get(@PathVariable Integer id){
		try {
			System.out.println("fetching id"+id);
			RonitPlacement placement = service.get(id);
			SahanaSACollege c = collegeservice.get(placement.getCollege_id());
			return new ResponseEntity<RonitDTO> (new RonitDTO(placement.getId(),placement.getName(),placement.getCollege(),placement.getDate(),placement.getQualification(),placement.getYear(),c),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RonitDTO> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Create operation
	@PostMapping("/placements")
	public ResponseEntity<String> add(@RequestBody RonitPlacement placement) {
		System.out.println("posting placements:"+placement);
		service.save(placement);
		return new ResponseEntity<String>("Pushed succesfully", HttpStatus.OK);
	}
	
	//Update operation
	@PutMapping("/placements/{id}")
	public ResponseEntity<?> update(@RequestBody RonitPlacement placement, @PathVariable Integer id){
		try {
			System.out.println("putting placements:"+placement+"from id:"+id);
			RonitPlacement exist = service.get(id);
			service.save(placement);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete operation
	@DeleteMapping("/placements/{id}")
	public void delete(@PathVariable Integer id) {
		System.out.println("Deleting from id:"+id);
		service.delete(id);
	}
	
}
