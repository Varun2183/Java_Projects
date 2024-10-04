package com.placement.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SahanaSACollege {
	
	@Id
	private int college_id;
	private String collegeAdmin;
	private String collegeName;
	private String location;
	@Column(name="user_Id")
	private Integer user_Id;
	
	public SahanaSACollege() {
		super();
	}

	public SahanaSACollege(int college_id, String collegeAdmin, String collegeName, String location, Integer user_Id) {
		super();
		this.college_id = college_id;
		this.collegeAdmin = collegeAdmin;
		this.collegeName = collegeName;
		this.location = location;
		this.user_Id = user_Id;
	}

	public int getCollege_id() {
		return college_id;
	}

	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}

	public String getCollegeAdmin() {
		return collegeAdmin;
	}

	public void setCollegeAdmin(String collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	@Override
	public String toString() {
		return "SahanaSACollege [college_id=" + college_id + ", collegeAdmin=" + collegeAdmin + ", collegeName="
				+ collegeName + ", location=" + location + ", user_Id=" + user_Id + ", getCollege_id()="
				+ getCollege_id() + ", getCollegeAdmin()=" + getCollegeAdmin() + ", getCollegeName()="
				+ getCollegeName() + ", getLocation()=" + getLocation() + ", getUser_Id()=" + getUser_Id()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	





	
}
