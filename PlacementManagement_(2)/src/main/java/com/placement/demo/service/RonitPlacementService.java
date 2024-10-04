package com.placement.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placement.demo.model.RonitPlacement;
import com.placement.demo.repository.RonitPlacementRepository;

@Service
@Transactional
public class RonitPlacementService {

	@Autowired
	private RonitPlacementRepository repository;
	
	public List<RonitPlacement> listAll(){
		return repository.findAll();
	}
	
	public RonitPlacement get(Integer id) {
		return repository.findById(id).get();
	}
	
	public void save(RonitPlacement placement) {
		repository.save(placement);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
