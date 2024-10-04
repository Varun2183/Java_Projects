package com.placement.demo.model;

import java.time.LocalDate;



import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ronitplacement")
public class RonitPlacement {
	@Id
	private Integer id;
	private String name;
	private String college;
	private LocalDate date;
	private String qualification;
	private Integer year;
	
	private Integer college_id;
	
	public RonitPlacement() {
		super();
	}
	
	public RonitPlacement(Integer id, String name, String college, LocalDate date, String qualification, Integer year,
			Integer college_id) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.date = date;
		this.qualification = qualification;
		this.year = year;
		this.college_id = college_id;
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
	
	
	public Integer getCollege_id() {
		return college_id;
	}

	public void setCollege_id(Integer college_id) {
		this.college_id = college_id;
	}

	@Override
	public String toString() {
		return "Placement [id=" + id + ", name=" + name + ", college=" + college + ", date=" + date + ", qualification="
				+ qualification + ", year=" + year + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getCollege()=" + getCollege() + ", getDate()=" + getDate() + ", getQualification()="
				+ getQualification() + ", getYear()=" + getYear() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
		
}
