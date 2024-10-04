package com.placement.demo.DTO;

import java.time.LocalDate;

import com.placement.demo.model.SahanaSACollege;

public class RonitDTO {
	
	private Integer id;
	private String name;
	private String college;
	private LocalDate date;
	private String qualification;
	private Integer year;
	
	private SahanaSACollege coll_ref;

	public RonitDTO(Integer id, String name, String college, LocalDate date, String qualification, Integer year,
			SahanaSACollege coll_ref) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.date = date;
		this.qualification = qualification;
		this.year = year;
		this.coll_ref = coll_ref;
	}

	public RonitDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public SahanaSACollege getColl_ref() {
		return coll_ref;
	}

	public void setColl_ref(SahanaSACollege coll_ref) {
		this.coll_ref = coll_ref;
	}
	
	
 }
