package com.placement.demo.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="chaitracertificate")
public class ChaitraCertificate {
	
	@Id
	private Integer id;
	private Integer year;
	private String college;
	
	private Integer college_id;
	
	
	public ChaitraCertificate() {
		super();
	}
	
	

	public ChaitraCertificate(Integer id, Integer year, String college, Integer college_id) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
		this.college_id = college_id;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
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

	public Integer getCollege_id() {
		return college_id;
	}



	public void setCollege_id(Integer college_id) {
		this.college_id = college_id;
	}



	@Override
	public String toString() {
		return "ChaitraCertificate [id=" + id + ", year=" + year + ", college=" + college + ", college_id=" + college_id
				+ ", getId()=" + getId() + ", getYear()=" + getYear() + ", getCollege()=" + getCollege()
				+ ", getCollege_id()=" + getCollege_id() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

	
	
	
	
}