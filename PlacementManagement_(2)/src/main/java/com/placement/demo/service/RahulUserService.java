package com.placement.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placement.demo.model.RahulUser;
import com.placement.demo.repository.RahulUserRepository;

@Service
@Transactional
public class RahulUserService {
	
	@Autowired
	private RahulUserRepository userrepository;
	
	public List<RahulUser> listAll(){
		return userrepository.findAll();
	}
	
	public RahulUser get(Integer id) {
		return userrepository.findById(id).get();
	}
	
	public void create(RahulUser user) {
		userrepository.save(user);
	}
	
	public void delete(Integer id) {
		userrepository.deleteById(id);
	}
}
