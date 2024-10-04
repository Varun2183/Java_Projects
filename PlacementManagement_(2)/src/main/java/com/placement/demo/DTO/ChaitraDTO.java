package com.placement.demo.DTO;

import com.placement.demo.model.SahanaSACollege;

public class ChaitraDTO {

	private Integer id;
	private Integer year;
	private String college;
	
	private SahanaSACollege college_id;

	public ChaitraDTO(Integer id, Integer year, String college, SahanaSACollege college_id) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
		this.college_id = college_id;
	}

	public ChaitraDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public SahanaSACollege getCollege_id() {
		return college_id;
	}

	public void setCollege_id(SahanaSACollege college_id) {
		this.college_id = college_id;
	}
	
	
}
