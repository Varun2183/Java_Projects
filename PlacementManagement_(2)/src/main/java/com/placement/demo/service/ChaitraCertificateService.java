package com.placement.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.placement.demo.model.ChaitraCertificate;
import com.placement.demo.repository.ChaitraCertificateRepository;

@Service
@Transactional
public class ChaitraCertificateService {
	
	@Autowired
	private ChaitraCertificateRepository certificaterepository;
	public List<ChaitraCertificate>listAll(){
		return certificaterepository.findAll();
	}
	public ChaitraCertificate get(Integer id) {
		return certificaterepository.findById(id).get();
	}
	public void create(ChaitraCertificate chaitraCertificate) {
		certificaterepository.save(chaitraCertificate);
	}
	public void delete(Integer id) {
		certificaterepository.deleteById(id);
	}
}
